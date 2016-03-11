package com.country.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.country.model.CountryDetail;
import com.country.model.CountryMaster;
import com.country.service.CountryService;

@RestController
public class Country {
	private CountryService countryService;
	@Autowired
	public Country(CountryService countryService) {
		this.countryService = countryService;
	}
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<CountryMaster> countryList(HttpServletResponse response) {
		response = setResponse(response);
		return countryService.countries();
	}
	
	@RequestMapping(value = "/{country}", method = RequestMethod.GET)
	@ResponseBody
	public List<CountryDetail> stateList(@PathVariable String country, HttpServletResponse response) {
		response = setResponse(response);
		return countryService.states(country);
	}
	
	@RequestMapping(value = "/{country}/{state}", method = RequestMethod.GET)
	@ResponseBody
	public List<CountryDetail> cityList(@PathVariable("country") String country, @PathVariable("state") String state, HttpServletResponse response) {
		response = setResponse(response);
		return countryService.cities(country, state);
	}
	
	@RequestMapping(value = "/{country}/{state}/{city}", method = RequestMethod.GET)
	@ResponseBody
	public List<CountryDetail> cityList(@PathVariable("country") String country, @PathVariable("state") String state, 
			@PathVariable("city") String city, HttpServletResponse response) {
		response = setResponse(response);
		return countryService.zipcodes(country, state, city);
	}
	
	@RequestMapping(value = "/{country}/{state}/{city}/{zipcode}", method = RequestMethod.GET)
	@ResponseBody
	public List<CountryDetail> countryDetails(@PathVariable("country") String country, @PathVariable("state") String state, 
			@PathVariable("city") String city, @PathVariable("zipcode") int zipcode, HttpServletResponse response) {
		response = setResponse(response);
		return countryService.details(country, state, city, zipcode);
	}
	
	public HttpServletResponse setResponse(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        return response;
	}
}