package com.country.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the countryDetails database table.
 * 
 */
@Entity
@Table(name="countryDetails")
public class CountryDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int countryDetailId;

	private String city;

	private int countryId;

	private String postOfficeName;
	
	private String countryName;

	private String state;

	private int zipcode;

	public CountryDetail() {
	}

	public int getCountryDetailId() {
		return this.countryDetailId;
	}

	public void setCountryDetailId(int countryDetailId) {
		this.countryDetailId = countryDetailId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getPostOfficeName() {
		return this.postOfficeName;
	}

	public void setPostOfficeName(String postOfficeName) {
		this.postOfficeName = postOfficeName;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}