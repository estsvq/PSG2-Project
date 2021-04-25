package org.springframework.samples.petclinic.web;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.model.Donation;
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
	public String viewCauseDetails(@PathVariable(value="causeId") int causeId, Model model) {
		Optional<Cause> optionalCause = causeService.findById(causeId);

		if (!optionalCause.isPresent()) {
			return "causes/causesList";
		}

		Cause cause = optionalCause.get();
		model.addAttribute("cause", cause);

		Double totalBudget = causeService.calculateCauseTotalBudget(cause);
		model.addAttribute("totalBudget", totalBudget);

		Set<Donation> donations = cause.getDonations();
		model.addAttribute("donations", donations);

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
	public String listAllCauses(Model model) {
		Iterable<Cause> causes = causeService.findAll();
		for(Cause c:causes){
			Double totalBudget = causeService.calculateCauseTotalBudget(c);
			c.setTotalBudget(totalBudget);
		}
		model.addAttribute("causes", causes);
		return "causes/causesList";
	}
}