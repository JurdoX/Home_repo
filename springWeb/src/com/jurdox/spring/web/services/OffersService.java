package com.jurdox.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jurdox.spring.web.dao.Offer;
import com.jurdox.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}
}
