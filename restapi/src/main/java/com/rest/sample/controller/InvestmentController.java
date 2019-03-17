package com.rest.sample.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.rest.sample.modal.Investment;
import com.rest.sample.modal.Investor;
import com.rest.sample.modal.response.Response;
import com.rest.sample.service.InvestmentService;

@Path("/investment")
public class InvestmentController {
	
	
	@POST
	@Path("/saveInvestment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveInvestment(@BeanParam Investment investment, @FormParam("investors") String investors ) throws SQLException {
		
		investment.setInvestors(new ArrayList<Investor>());
		
		try {
			
			JSONArray investorsArr = new JSONArray(investors);
			for (int i = 0; i < investorsArr.length(); i++) {
				JSONObject investor = investorsArr.getJSONObject(i);
				Investor investorObj = new Investor(investor.getString("name"), investor.getString("ownership"), investor.getString("blaOne"));
				investment.getInvestors().add(investorObj);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}

		Response response = new Response();
		response.setData(InvestmentService.saveInvestment(investment));
		return response;
	}

}
