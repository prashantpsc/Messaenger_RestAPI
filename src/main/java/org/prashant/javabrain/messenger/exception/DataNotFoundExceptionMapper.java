package org.prashant.javabrain.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.prashant.javabrain.messenger.Model.Error;; 

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		
		Error e = new Error("404 not found", 404, "document");
		
		return Response.status(Status.NOT_FOUND).entity(e).build();
	}

}
