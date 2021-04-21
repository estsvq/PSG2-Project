package org.springframework.samples.petclinic.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.service.CauseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CauseController {

	private static final String VIEWS_CAUSE_CREATE_FORM = "causes/createCausesForm";
	
	CauseService causeService;

	@Autowired public CauseController(CauseService causeService) {
		this.causeService = causeService;
	}
	
	
	@GetMapping(value = "/causes/new")	
	public String createCauseView(Map<String, Object> model) {		
		Cause cause = new Cause();
		model.put("cause", cause);
		return VIEWS_CAUSE_CREATE_FORM;
	}
	
	@PostMapping(value = "/causes/new")
	public String processCreationForm(Cause cause, BindingResult result) {
		System.out.println(cause);
		if (result.hasErrors()) {
			return VIEWS_CAUSE_CREATE_FORM;
		}
		else {
			//creating cause
			this.causeService.saveCause(cause);			
			return "redirect:/causes";
		}
	}
	
	/*
	@RequestMapping(value = "/causes/new")
	public String createCause(Map<String, Object> model) {		
		return "welcome";
		// return VIEWS_CAUSE_CREATE_FORM;
	}
	*/
	@GetMapping(value = "/causes")
	public String listAllCauses(Map<String, Iterable<Cause>> model){
		Iterable<Cause> causes = causeService.findAll();
		model.put("causes", causes);
		return "causes/causesList";
	}
	
}
