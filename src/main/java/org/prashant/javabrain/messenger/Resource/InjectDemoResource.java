package org.prashant.javabrain.messenger.Resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;



@Path(value = "/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotation")
	@Produces(MediaType.APPLICATION_JSON)
	public String message(@MatrixParam("param") String value,
							@HeaderParam("auth") int auth,
							@CookieParam("JSESSIONID") String name)
	{
		String str = "";
		if(auth == 006)
		{
			str= "prashant fb password is 000";
		}
		return "annotation:Hello prashant :" + value +" "+ str + "cokkie value:" + name;
	}
	
	@GET
	@Path("Bean")
	@Produces(MediaType.APPLICATION_JSON)
	public String message(@BeanParam MessageFilterBean m)
	{
		
		String str = "";
		if(m.getAuth() == 006)
		{
			str= "prashant fb password is 000";
		}
		return "Hello prashant :" + m.getValue() +" "+ str + "cokkie value:" + m.getName();
	}
	
	
	@GET
	@Path("param")
	@Produces(MediaType.APPLICATION_JSON)
	public String message(@Context UriInfo uri,
			              @Context HttpHeaders head)
	{
	
		return "uri "+ uri.getAbsolutePath().toString() + " header: " + head.getCookies().toString();
	}
}
