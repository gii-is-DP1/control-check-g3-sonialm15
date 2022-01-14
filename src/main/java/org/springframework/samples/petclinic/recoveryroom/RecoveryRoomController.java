package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
	private static final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

	private final RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}
	
	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		model.addAttribute("recoveryRoom", new RecoveryRoom());
		model.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
		return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {		
		String view = "welcome";
		if (result.hasErrors()) {
			model.addAttribute("recoveryRoom", recoveryRoom);
			model.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
			return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
        recoveryRoomService.save(recoveryRoom);
        model.addAttribute("message", "Room succesfully saved!");
        return view;
		}
	}
}
