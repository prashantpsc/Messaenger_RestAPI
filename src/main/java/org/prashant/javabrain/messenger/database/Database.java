package org.prashant.javabrain.messenger.database;

import java.util.HashMap;
import java.util.Map;
import org.prashant.javabrain.messenger.Model.Message;
import org.prashant.javabrain.messenger.Model.Profile;


public class Database {
	
	private static Map<Long,Message> message = new HashMap<>();
	private static Map<String,Profile> profile = new HashMap<>();
	
	public static Map<Long,Message> getMessage(){
		return message;
	}

	public static Map<String,Profile> getProfiles(){
		return profile;
	}
}
