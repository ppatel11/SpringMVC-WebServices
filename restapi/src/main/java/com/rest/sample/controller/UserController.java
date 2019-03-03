package com.rest.sample.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rest.sample.modal.User;
import com.rest.sample.modal.response.Response;
import com.rest.sample.service.UserService;

@Path("/user")
public class UserController {

	@GET
	@Path("/getAllUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() throws SQLException {
		Response response = new Response();
		response.setData(UserService.findByAll());
		return response;
	}

	@GET
	@Path("/getUserById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@QueryParam("loginName") String loginName) throws SQLException {
		
		Response response = new Response();
		User user = UserService.findById(loginName);
		response.setData(user);
		if(user == null) {
			response.getMessage().add("No Employee available for id : " + loginName);
		}
		return  response;
	}
	
	
}