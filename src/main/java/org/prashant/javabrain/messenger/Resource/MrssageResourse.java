package org.prashant.javabrain.messenger.Resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Provider.Service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.prashant.javabrain.messenger.Model.Message;
import org.prashant.javabrain.messenger.service.MessageService;

@Path(value = "/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MrssageResourse {

	MessageService s = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> message(@QueryParam("start") int st ,
							     @QueryParam("size") int sz)
	{
		
		if(st >= 0 && sz  >0)
		{
			return s.getAllmessagePaginated(st, sz);
		}
		return s.getAllmessage();
	}

	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageID") long id)
	{
		
		
		
		return s.getMessage(id);
		
	}
	
	//@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	//public  Message addMessage(Message a)
	//{
	//	return s.addMessage(a);
	//}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Response  addMessage(Message a ,@Context UriInfo uri) throws URISyntaxException
	{
		Message m = s.addMessage(a);
		URI url =  uri.getAbsolutePathBuilder().path(String.valueOf(m.getId())).build();
		return Response.created(url)
				.entity(m)
				.build();
	}
	
	@PUT
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Message updateMessage(@PathParam("messageID") long id , Message a)
	{
		a.setId(id);
		return s.updateMessage(a);
	}
	
	@DELETE
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public  void deleteMessage(@PathParam("messageID") long id)
	{
		
		s.removeMessage(id);
	}
	
	//method level path for sub resource
	@Path("/{messageid}/comment")
	public CommentResource commentresource()
	{
	
		return new CommentResource();
	}
}
