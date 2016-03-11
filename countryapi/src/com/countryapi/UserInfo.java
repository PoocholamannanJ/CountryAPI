package com.countryapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("UserInfoService")
public class UserInfo {
	@GET
	@Path("/name/{i}")
	@Produces(MediaType.APPLICATION_XML)
	public CountryMaster userName(@PathParam("i") String i) {
		String name = i;
		CountryMaster country = new CountryMaster();
		country.setCountryId(1);
		country.setCountryName(name);
		return country;
	}
	@GET 
	@Path("/age/{j}") 
	@Produces(MediaType.TEXT_XML)
	public String userAge(@PathParam("j") int j) {
		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}
}
