package com.country.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the countryMaster database table.
 * 
 */
@Entity
@Table(name="countryMaster")
public class CountryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int countryId;

	private String countryName;

	public CountryMaster() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}