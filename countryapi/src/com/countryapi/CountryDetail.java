package com.countryapi;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
public class CountryDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int countryDetailId;
	private int countryId;
	private String postOfficeName;
	private String countryName;
	private String state;
	private String city;
	private int zipcode;
	
	@XmlElement
	public int getCountryDetailId() {
		return countryDetailId;
	}
	public void setCountryDetailId(int countryDetailId) {
		this.countryDetailId = countryDetailId;
	}
	
	@XmlElement
	public int getCountryId() {
		return countryId;
	}
	
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	@XmlElement
	public String getPostOfficeName() {
		return postOfficeName;
	}
	
	public void setPostOfficeName(String postOfficeName) {
		this.postOfficeName = postOfficeName;
	}
	
	@XmlElement
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@XmlElement
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@XmlElement
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@XmlElement
	public int getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}