package com.parser.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.parser.controller.ParsingController;
import com.parser.dto.ClaimDto;

@Path("/claim")
public class ClaimsResource {
	
	@GET 
	@Produces (MediaType.APPLICATION_JSON)
	public Response getClaims(@QueryParam("file") String fileName) {
		fileName = "/Users/shubhambansal/Downloads/cancer.pdf";
		try {
			ParsingController controller = new ParsingController();
			controller.parse(fileName);
			ClaimDto claim = new ClaimDto(controller.getClaim());
			return Response.ok(claim).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
}
