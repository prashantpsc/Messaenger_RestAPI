package org.prashant.javabrain.messenger.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Provider.Service;

import org.prashant.javabrain.messenger.Model.Profile;
import org.prashant.javabrain.messenger.service.ProfileService;

@Path(value = "/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	
	ProfileService s = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> profile()
	{
		
		return s.getAllprofile();
	}

	@GET
	@Path("/{ProfileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile test(@PathParam("ProfileName") String id)
	{		

		return s.getProfile(id);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Profile addProfile(Profile a)
	{
			

		return s.addProfile(a);
	}
	
	@PUT
	@Path("/{profilename}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Profile updateMessage(@PathParam("profilename") String profilename , Profile a)
	{
		a.setProfileName(profilename);
		return s.updateProfile(a);
	}
	
	@DELETE
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public  void deleteMessage(@PathParam("messageID") String id)
	{
		s.removeMessage(id);
	}

}
