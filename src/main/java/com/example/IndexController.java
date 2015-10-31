package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexController {
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	private static final String TITLE = "Cache Test Application";

	@Autowired
	private DomainRepository domainRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getPatient(Map<String, Object> model) {
		model.put("message", TITLE);
		model.put("user", new User());
		return "index";
	}

	@RequestMapping(value="/", method= RequestMethod.POST)
	public String getPatient(@ModelAttribute User user, Map<String, Object> model) {
		LOGGER.info("Getting the Patient Details");
		model.put("userId", domainRepository.getEntriesFromBp(user.getId()));
		model.put("message", TITLE);
		return "index";
	}
}
