package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.service.CauseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CauseController {

	private final CauseService causeService;

	private static final String VIEWS_CAUSE_CREATE_FORM = "causes/createCausesForm";

	@Autowired
	public CauseController(CauseService causeService) {
		this.causeService = causeService;
	}

	@GetMapping(value = "/causes/{causeId}")
	public String initFindForm(@PathVariable(value="causeId") int ownerId, Model model) {
		Cause cause = causeService.findById(ownerId);

		if (cause == null) {
			return "causes/causesList";
		}

		model.addAttribute("cause", cause);

		// TODO Add donations listing when it is ready

		return "causes/causeDetails";
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
		} else {
			// creating cause
			this.causeService.saveCause(cause);
			return "redirect:/causes";
		}
	}

	/*
	 * @RequestMapping(value = "/causes/new") public String createCause(Map<String,
	 * Object> model) { return "welcome"; // return VIEWS_CAUSE_CREATE_FORM; }
	 */
	@GetMapping(value = "/causes")
	public String listAllCauses(Map<String, Iterable<Cause>> model) {
		Iterable<Cause> causes = causeService.findAll();
		model.put("causes", causes);
		return "causes/causesList";
	}
}