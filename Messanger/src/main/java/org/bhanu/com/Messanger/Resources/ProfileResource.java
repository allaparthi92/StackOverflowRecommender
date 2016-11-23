package org.bhanu.com.Messanger.Resources;

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

import org.bhanu.service.ProfileService;
import orga.bhanu.model.Message;
import orga.bhanu.model.Profile;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{ProfileName}")
	public Profile getMessage(@PathParam("ProfileName") String ProfileName) {
		return profileService.getProfile(ProfileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateMessage(Profile profile,@PathParam("ProfileName") String ProfileName) {
		profile.setProfilename(ProfileName);
		return profileService.updateMessage(profile);
	}
	
	
	@DELETE
	@Path("/{ProfileName}")
	public Profile deleteMessage(@PathParam("ProfileName") String ProfileName) {
		return profileService.removeProfile(ProfileName);
	}
	
}
