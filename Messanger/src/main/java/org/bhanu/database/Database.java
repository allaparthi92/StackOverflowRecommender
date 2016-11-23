package org.bhanu.database;

import java.util.HashMap;
import java.util.Map;

import orga.bhanu.model.Message;
import orga.bhanu.model.Profile;

public class Database {
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
}
