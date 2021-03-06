package me.limeglass.skungee.spigot.elements.events;

import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import me.limeglass.skungee.objects.events.SkungeeMessageEvent;
import me.limeglass.skungee.spigot.elements.Events;

public class EvtSkungeeMessage extends SkriptEvent {
	
	static {
		Events.registerEvent(EvtSkungeeMessage.class, SkungeeMessageEvent.class, "(bungeecord|skungee) message [[from] [channel[s]] %strings%]");
		EventValues.registerEventValue(SkungeeMessageEvent.class, String.class, new Getter<String, SkungeeMessageEvent>() {
			@Override
			@Nullable
			public String get(final SkungeeMessageEvent event) {
				return event.getChannel();
			}
		}, 0);
	}
	
	@Nullable
	private Literal<String> channels;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Literal<?>[] args, int matchedPattern, ParseResult parseResult) {
		if (args == null || args.length == 0) return true;
		channels = (Literal<String>) args[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event event, boolean debug) {
		return "Skungee message from requested channel: " + channels.toString(event, debug) + " with messages: " + ((SkungeeMessageEvent)event).getMessages();
	}

	public boolean check(Event event) {
		if (channels == null || channels.getSingle(event) == null) return true;
		for (String channel : channels.getArray()) {
			if (((SkungeeMessageEvent)event).getChannel().equals(channel)) return true;
		}
		return false;
	}
}
