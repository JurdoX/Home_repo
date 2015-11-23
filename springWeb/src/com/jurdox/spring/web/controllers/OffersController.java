package com.jurdox.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jurdox.spring.web.dao.Offer;
import com.jurdox.spring.web.services.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showOffers(Model model, @RequestParam("id") String id) {
		System.out.println("Id is: " + id);
		return "offers";
	}

	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if (result.hasErrors()) {
			return "createoffer";
		}
		
		return "offercreated";
	}
}
