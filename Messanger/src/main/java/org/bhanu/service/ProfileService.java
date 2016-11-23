package org.bhanu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bhanu.database.Database;
import orga.bhanu.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = Database.getProfiles();

	public ProfileService(){
		profiles.put("Kaiushik",new Profile(1L,"Kaiushik","Kaiushik","Kaiushik"));
	}
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String Name) {
		return profiles.get(Name);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put( profile.getProfilename(), profile);
		return profile;
	}

	public Profile updateMessage(Profile profile) {
		if (profile.getProfilename().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfilename(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
