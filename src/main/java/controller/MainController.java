package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.CrawlRepository;

@Controller
public class MainController {
	@Autowired
	CrawlRepository crawlRepo;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String listCustomer(Model model) {
	
		model.addAttribute("list", crawlRepo.findAll());
		return "employees";
	}

}
