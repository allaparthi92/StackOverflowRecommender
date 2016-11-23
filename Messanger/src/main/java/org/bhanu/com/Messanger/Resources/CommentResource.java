package org.bhanu.com.Messanger.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {
	
	@GET
	public String test(){
		return "hiBhanu";
	}
}
