package me.limeglass.skungee.objects.packets;

import java.io.Serializable;

import me.limeglass.skungee.objects.SkungeeEnums.SkriptChangeMode;
import me.limeglass.skungee.objects.SkungeePlayer;

public class SkungeePacket implements Serializable {

	private static final long serialVersionUID = -7377209366283539512L;
	private final Boolean returnable;
	private SkriptChangeMode changeMode;
	private SkungeePlayer[] players;
	private Object settable, object;
	private SkungeePacketType type;
	private byte[] password;
	//Used for external packets, extend this SkungeePacket and set the name to then call the name on Bungeecord through handlers.
	//The name or the type must be set or else the packet will become a dummy packet on Bungeecord. (Also needs the handler)
	private String name;
	
	public SkungeePacket(Boolean returnable) {
		this.returnable = returnable;
	}
	
	public SkungeePacket(Boolean returnable, String name) {
		this.returnable = returnable;
		this.name = name;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type) {
		this.returnable = returnable;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, String name, Object object) {
		this.returnable = returnable;
		this.object = object;
		this.name = name;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object) {
		this.returnable = returnable;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, String name, Object object, Object settable) {
		this.returnable = returnable;
		this.settable = settable;
		this.object = object;
		this.name = name;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, Object settable) {
		this.returnable = returnable;
		this.settable = settable;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, String name, Object object, SkungeePlayer... players) {
		this.returnable = returnable;
		this.players = players;
		this.object = object;
		this.name = name;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, SkungeePlayer... players) {
		this.returnable = returnable;
		this.players = players;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, SkriptChangeMode changeMode) {
		this.returnable = returnable;
		this.changeMode = changeMode;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, Object settable, SkungeePlayer... players) {
		this.returnable = returnable;
		this.settable = settable;
		this.players = players;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, Object settable, SkriptChangeMode changeMode) {
		this.returnable = returnable;
		this.changeMode = changeMode;
		this.settable = settable;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, SkriptChangeMode changeMode, SkungeePlayer... players) {
		this.returnable = returnable;
		this.changeMode = changeMode;
		this.players = players;
		this.object = object;
		this.type = type;
	}
	
	public SkungeePacket(Boolean returnable, SkungeePacketType type, Object object, Object settable, SkriptChangeMode changeMode, SkungeePlayer... players) {
		this.returnable = returnable;
		this.changeMode = changeMode;
		this.settable = settable;
		this.players = players;
		this.object = object;
		this.type = type;
	}

	public Boolean isReturnable() {
		return returnable;
	}
	
	public SkungeePlayer[] getPlayers() {
		return players;
	}
	
	public void setPlayers(SkungeePlayer... players) {
		this.players = players;
	}
	
	public SkriptChangeMode getChangeMode() {
		return changeMode;
	}
	
	public void setChangeMode(SkriptChangeMode changeMode) {
		this.changeMode = changeMode;
	}
	
	public byte[] getPassword() {
		return password;
	}
	
	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public Object getSetObject() {
		return settable;
	}
	
	public void setSettableObject(Object settable) {
		this.settable = settable;
	}
	
	public Boolean objectsAreNull() {
		return object == null && settable == null;
	}
	
	public Boolean eitherObjectsAreNull() {
		return object == null || settable == null;
	}
	
	public SkungeePacketType getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
