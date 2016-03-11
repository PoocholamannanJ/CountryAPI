package com.countryapi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("country")
public class Country {
	private String query = null;
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryMaster> getCountry() {
		List<CountryMaster> countries = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select countryId, countryName from countryMaster ";
				preparedStatement = conn.prepareStatement(query);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					countries = new ArrayList<CountryMaster>();
					CountryMaster countryMaster = null;
					while(country.next()) {
						countryMaster = new CountryMaster();
						countryMaster.setCountryId((Integer) country.getInt(1));
						countryMaster.setCountryName(String.valueOf(country.getString(2)));
						countries.add(countryMaster);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
	
	@GET
	@Path("/{country}")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryDetail> getStates(@PathParam("country") String countryName) {
		List<CountryDetail> states = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select a.countryId, a.countryName, b.countryDetailId, b.state from countryMaster a "
						+ "inner join countryDetails b on a.countryId = b.countryId where a.countryName = ? group by b.state";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, countryName);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					states = new ArrayList<CountryDetail>();
					CountryDetail countryDetail = null;
					while(country.next()) {
						countryDetail = new CountryDetail();
						countryDetail.setCountryId((Integer) country.getInt(1));
						countryDetail.setCountryName(String.valueOf(country.getString(2)));
						countryDetail.setCountryDetailId((Integer) country.getInt(3));
						countryDetail.setState(String.valueOf(country.getString(4)));
						states.add(countryDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	@GET
	@Path("/{country}/{state}")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryDetail> getCities(@PathParam("country") String countryName, @PathParam("state") String state) {
		List<CountryDetail> states = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city from countryMaster a "
						+ "inner join countryDetails b on a.countryId = b.countryId where a.countryName = ? and b.state = ? group by b.city";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, countryName);
				preparedStatement.setString(2, state);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					states = new ArrayList<CountryDetail>();
					CountryDetail countryDetail = null;
					while(country.next()) {
						countryDetail = new CountryDetail();
						countryDetail.setCountryId((Integer) country.getInt(1));
						countryDetail.setCountryName(String.valueOf(country.getString(2)));
						countryDetail.setCountryDetailId((Integer) country.getInt(3));
						countryDetail.setState(String.valueOf(country.getString(4)));
						countryDetail.setCity(country.getString(5));
						states.add(countryDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	/*@GET
	@Path("/{country}/{state}")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryDetail> getStates(@PathParam("country") String countryName, @PathParam("state") String state) {
		List<CountryDetail> states = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city from countryMaster a "
						+ "inner join countryDetails b on a.countryId = b.countryId where a.countryName = ? and b.state = ? group by b.city";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, countryName);
				preparedStatement.setString(2, state);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					states = new ArrayList<CountryDetail>();
					CountryDetail countryDetail = null;
					while(country.next()) {
						countryDetail = new CountryDetail();
						countryDetail.setCountryId((Integer) country.getInt(1));
						countryDetail.setCountryName(String.valueOf(country.getString(2)));
						countryDetail.setCountryDetailId((Integer) country.getInt(3));
						countryDetail.setState(String.valueOf(country.getString(4)));
						countryDetail.setCity(country.getString(5));
						states.add(countryDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}*/
	
	@GET
	@Path("/{country}/{state}/{city}")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryDetail> getCities(@PathParam("country") String countryName, 
			@PathParam("state") String state, @PathParam("city") String city) {
		List<CountryDetail> states = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city, b.postOfficeName, b.zipcode from countryMaster a "
						+ "inner join countryDetails b on a.countryId = b.countryId where a.countryName = ? and b.state = ? and b.city = ? group by b.postOfficeName";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, countryName);
				preparedStatement.setString(2, state);
				preparedStatement.setString(3, city);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					states = new ArrayList<CountryDetail>();
					CountryDetail countryDetail = null;
					while(country.next()) {
						countryDetail = new CountryDetail();
						countryDetail.setCountryId((Integer) country.getInt(1));
						countryDetail.setCountryName(String.valueOf(country.getString(2)));
						countryDetail.setCountryDetailId((Integer) country.getInt(3));
						countryDetail.setState(String.valueOf(country.getString(4)));
						countryDetail.setCity(country.getString(5));
						countryDetail.setPostOfficeName(country.getString(6));
						countryDetail.setZipcode((Integer) country.getInt(7));
						states.add(countryDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	@GET
	@Path("/{country}/{state}/{city}/{zipcode}")
	@Produces(MediaType.APPLICATION_XML)
	public List<CountryDetail> getDetails(@PathParam("country") String countryName, 
			@PathParam("state") String state, @PathParam("city") String city, @PathParam("zipcode") int zipcode) {
		List<CountryDetail> states = null;
		try {
			conn = MysqlConnection.getConnection();
			if(conn != null) {
				query = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city, b.postOfficeName, b.zipcode from countryMaster a "
						+ "inner join countryDetails b on a.countryId = b.countryId where a.countryName = ? and b.state = ? and b.city = ? and zipcode = ?";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, countryName);
				preparedStatement.setString(2, state);
				preparedStatement.setString(3, city);
				preparedStatement.setInt(4, zipcode);
				ResultSet country = preparedStatement.executeQuery();
				if(country != null && country.next()) {
					country.beforeFirst();
					states = new ArrayList<CountryDetail>();
					CountryDetail countryDetail = null;
					while(country.next()) {
						countryDetail = new CountryDetail();
						countryDetail.setCountryId((Integer) country.getInt(1));
						countryDetail.setCountryName(String.valueOf(country.getString(2)));
						countryDetail.setCountryDetailId((Integer) country.getInt(3));
						countryDetail.setState(String.valueOf(country.getString(4)));
						countryDetail.setCity(country.getString(5));
						countryDetail.setPostOfficeName(country.getString(6));
						countryDetail.setZipcode((Integer) country.getInt(7));
						states.add(countryDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
}
