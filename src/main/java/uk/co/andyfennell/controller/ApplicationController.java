package uk.co.andyfennell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.andyfennell.model.Country;
import uk.co.andyfennell.service.DataService;
import uk.co.andyfennell.service.DataSimple;

@Controller
public class ApplicationController {
	
	private DataService dataService;
	
	@RequestMapping(value="/")
	public String Home(ModelMap model) {
		System.out.println("ApplicationController");
		
		//model.addAttribute("message", "H e l l o  W o r l d !");
		//DataSimple data = new DataSimple();
		String message = dataService.getMessage();
		String[] countries = dataService.getCountries();
		Country[] countryList = dataService.getCountryList();
		
		model.addAttribute("message", message);
		model.addAttribute("countries", countries);
		model.addAttribute("countryList", countryList);
		
		return "index";		
	}
	
	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}
