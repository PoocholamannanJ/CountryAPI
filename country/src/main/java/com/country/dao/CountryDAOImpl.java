package com.country.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("countryDAO")
public class CountryDAOImpl implements CountryDAO {
	private SessionFactory sessionFactory;
	private String hql;
	@Autowired
	public CountryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCountries() throws Exception {
		try {
			hql = "select countryId, countryName from CountryMaster";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getStates(String country) throws Exception {
		try {
			hql = "select a.countryId, a.countryName, b.countryDetailId, b.state from CountryMaster a , CountryDetail b where a.countryId = b.countryId and a.countryName = :country group by b.state";
			return sessionFactory.getCurrentSession().createQuery(hql).setParameter("country", country).list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCities(String country, String state) throws Exception {
		try {
			hql = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city from CountryMaster a ,CountryDetail b where a.countryId = b.countryId and a.countryName = :country and b.state = :state group by b.city";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("country", country).setParameter("state", state).list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getZipCodes(String country, String state, String city) throws Exception {
		try {
			hql = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city, b.postOfficeName, b.zipcode from CountryMaster a ,CountryDetail b where a.countryName = :country and a.countryName = :country and b.state = :state and b.city = :city group by b.postOfficeName";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("country", country)
					.setParameter("state", state).setParameter("city", city).list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getDetails(String country, String state, String city, int zipcode) throws Exception {
		try {
			hql = "select a.countryId, a.countryName, b.countryDetailId, b.state, b.city, b.postOfficeName, b.zipcode from CountryMaster a ,CountryDetail b where a.countryName = :country and a.countryName = :country and b.state = :state and b.city = :city and zipcode = :zipcode";
			return sessionFactory.getCurrentSession().createQuery(hql)
					.setParameter("country", country)
					.setParameter("state", state)
					.setInteger("zipcode", zipcode).setParameter("city", city).list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
