package com.country.service;

import java.util.List;

import com.country.model.CountryDetail;
import com.country.model.CountryMaster;

public interface CountryService {
	public List<CountryMaster> countries();
	public List<CountryDetail> states(String country);
	public List<CountryDetail> cities(String country, String stateName);
	public List<CountryDetail> zipcodes(String country, String stateName, String city);
	public List<CountryDetail> details(String country, String stateName, String city, int zipcode);
}