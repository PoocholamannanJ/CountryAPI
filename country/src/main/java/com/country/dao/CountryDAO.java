package com.country.dao;

import java.util.List;

public interface CountryDAO {
	public List<Object[]> getCountries() throws Exception;
	public List<Object[]> getStates(String country) throws Exception;
	public List<Object[]> getCities(String country, String state) throws Exception;
	public List<Object[]> getZipCodes(String country, String state, String city) throws Exception;
	public List<Object[]> getDetails(String country, String state, String city, int zipcode) throws Exception;
}
