package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IndexController {

	@Autowired
	private DomainRepository domainRepository;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "Cache Test Application");
		return "index";
	}

	@RequestMapping(value="/getPatient", method= RequestMethod.POST)
	public String getPatient(Map<String, Object> model) {
		model.put("patient", domainRepository.getEntriesFromBp("1234"));
		return "index";
	}
}
