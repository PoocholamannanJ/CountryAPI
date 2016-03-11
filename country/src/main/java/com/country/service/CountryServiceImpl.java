package com.country.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.dao.CountryDAO;
import com.country.model.CountryDetail;
import com.country.model.CountryMaster;

@Service("countryService")
public class CountryServiceImpl implements CountryService {
	private CountryDAO countryDAO;
	@Autowired
	public CountryServiceImpl(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}
	@Transactional
	@Override
	public List<CountryMaster> countries() {
		List<CountryMaster> countryList = null;
		List<Object[]> country = null;
		CountryMaster countryMaster = null;
		try {
			country = countryDAO.getCountries();
			if(country != null && country.size() > 0) {
				countryList = new ArrayList<CountryMaster>();
				Iterator<Object[]> iterator = country.iterator();
				Object[] objects = null;
				while (iterator.hasNext()) {
					countryMaster = new CountryMaster();
					objects = (Object[]) iterator.next();
					countryMaster.setCountryId((Integer) objects[0]);
					countryMaster.setCountryName(String.valueOf(objects[1]));
					countryList.add(countryMaster);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return countryList;
	}
	
	@Transactional
	@Override
	public List<CountryDetail> states(String country) {
		List<CountryDetail> stateList = null;
		List<Object[]> state = null;
		CountryDetail countryDetail = null;
		try {
			state = countryDAO.getStates(country);
			if(state != null && state.size() > 0) {
				stateList = new ArrayList<CountryDetail>();
				Iterator<Object[]> iterator = state.iterator();
				Object[] objects = null;
				while (iterator.hasNext()) {
					countryDetail = new CountryDetail();
					objects = (Object[]) iterator.next();
					countryDetail.setCountryId((Integer) objects[0]);
					countryDetail.setCountryName(String.valueOf(objects[1]));
					countryDetail.setCountryDetailId((Integer) objects[2]);
					countryDetail.setState(String.valueOf(objects[3]));
					stateList.add(countryDetail);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stateList;
	}
	
	@Transactional
	@Override
	public List<CountryDetail> cities(String country, String stateName) {
		List<CountryDetail> stateList = null;
		List<Object[]> state = null;
		CountryDetail countryDetail = null;
		try {
			state = countryDAO.getCities(country, stateName);
			if(state != null && state.size() > 0) {
				stateList = new ArrayList<CountryDetail>();
				Iterator<Object[]> iterator = state.iterator();
				Object[] objects = null;
				while (iterator.hasNext()) {
					countryDetail = new CountryDetail();
					objects = (Object[]) iterator.next();
					countryDetail.setCountryId((Integer) objects[0]);
					countryDetail.setCountryName(String.valueOf(objects[1]));
					countryDetail.setCountryDetailId((Integer) objects[2]);
					countryDetail.setState(String.valueOf(objects[3]));
					countryDetail.setCity(String.valueOf(objects[4]));
					stateList.add(countryDetail);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stateList;
	}
	
	@Transactional
	@Override
	public List<CountryDetail> zipcodes(String country, String stateName, String city) {
		List<CountryDetail> stateList = null;
		List<Object[]> state = null;
		CountryDetail countryDetail = null;
		try {
			state = countryDAO.getZipCodes(country, stateName, city);
			if(state != null && state.size() > 0) {
				stateList = new ArrayList<CountryDetail>();
				Iterator<Object[]> iterator = state.iterator();
				Object[] objects = null;
				while (iterator.hasNext()) {
					countryDetail = new CountryDetail();
					objects = (Object[]) iterator.next();
					countryDetail.setCountryId((Integer) objects[0]);
					countryDetail.setCountryName(String.valueOf(objects[1]));
					countryDetail.setCountryDetailId((Integer) objects[2]);
					countryDetail.setState(String.valueOf(objects[3]));
					countryDetail.setCity(String.valueOf(objects[4]));
					countryDetail.setPostOfficeName(String.valueOf(objects[5]));
					countryDetail.setZipcode((Integer) objects[6]);
					stateList.add(countryDetail);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stateList;
	}
	
	@Transactional
	@Override
	public List<CountryDetail> details(String country, String stateName, String city, int zipcode) {
		List<CountryDetail> stateList = null;
		List<Object[]> state = null;
		CountryDetail countryDetail = null;
		try {
			state = countryDAO.getDetails(country, stateName, city, zipcode);
			if(state != null && state.size() > 0) {
				stateList = new ArrayList<CountryDetail>();
				Iterator<Object[]> iterator = state.iterator();
				Object[] objects = null;
				while (iterator.hasNext()) {
					countryDetail = new CountryDetail();
					objects = (Object[]) iterator.next();
					countryDetail.setCountryId((Integer) objects[0]);
					countryDetail.setCountryName(String.valueOf(objects[1]));
					countryDetail.setCountryDetailId((Integer) objects[2]);
					countryDetail.setState(String.valueOf(objects[3]));
					countryDetail.setCity(String.valueOf(objects[4]));
					countryDetail.setPostOfficeName(String.valueOf(objects[5]));
					countryDetail.setZipcode((Integer) objects[6]);
					stateList.add(countryDetail);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stateList;
	}
}
