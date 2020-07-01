package org.prashant.javabrain.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.prashant.javabrain.messenger.Model.Profile;
import org.prashant.javabrain.messenger.database.Database;

public class ProfileService {

	
	private Map<String, Profile> profile = Database.getProfiles();

	public ProfileService()
	{
		Profile m1 = new Profile(1L,"Hellsingh","Prashnat","newton");
		Profile m2 = new Profile(2L,"Hellsingh2","Prashant","Telsa");
		profile.put("pra1", m1);
		profile.put("pra2", m2);
	}
	
	
	public List<Profile> getAllprofile()
	{
	 return new ArrayList<Profile>(profile.values());
	}
	
	
	
	public Profile getProfile(String id)
	{
		return profile.get(id);
	}

	public Profile addProfile(Profile pro)
	{
		

		pro.setId(profile.size() +1 );
		
		profile.put(pro.getProfileName(), pro);
		
		return pro;
	}
	
	public Profile updateProfile(Profile m)
	{
		if(m.getProfileName().isEmpty())
		{
			return null;
		}
	
		profile.put(m.getProfileName(), m);
		
		return m;
	}
	
	public Profile removeMessage(String id)
	{
		return profile.remove(id);
	}
	
}
