package org.prashant.javabrain.messenger.Resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//path is optional for sub resource
@Path("/")
public class CommentResource {

	
	@GET
	public String test()
	{
		return "CommentResource"; 
	}
	
	@GET
	@Path("/{commentid}")
	public String comment(@PathParam("commentid") long cid)
	{
		return "commnet :" + cid;
	}
}
