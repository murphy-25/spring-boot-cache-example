package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	private static final String TITLE = "Cache Test Application";

	@Autowired
	private DomainRepository domainRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getPatient(Map<String, Object> model) {
		model.put("message", TITLE);
		model.put("patient", new Patient());
		return "index";
	}

	@RequestMapping(value="/", method= RequestMethod.POST)
	public String getPatient(@ModelAttribute Patient patient, Map<String, Object> model) {
		log.info("Getting the Patient Details");
		model.put("patientId", domainRepository.getEntriesFromBp(patient.getId()));
		model.put("message", TITLE);
		return "index";
	}
}
