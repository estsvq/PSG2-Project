package org.springframework.samples.petclinic.web;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Cause;
import org.springframework.samples.petclinic.service.CauseService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CauseController {
    
    private final CauseService causeService;

	@Autowired
	public CauseController(CauseService causeService) {
		this.causeService = causeService;
	}

    @GetMapping(value = "/causes/{causeId}")
	public String initFindForm(@PathVariable("causeId") int ownerId, BindingResult result, Map<String, Object> model) {
		Optional<Cause> optionalCause = causeService.getCauseById(ownerId);

        if(optionalCause.isEmpty()) {
            result.rejectValue("causeId", "notFound", "Cause was not found.");
            return "causes/causesList";
        }

        Cause cause = optionalCause.get();
        
        model.put("cause", cause);

        //TODO Add donations listing when it is ready

		return "causes/causeDetails";
	}
}
