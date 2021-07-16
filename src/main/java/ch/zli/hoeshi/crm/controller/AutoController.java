package ch.zli.hoeshi.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.hoeshi.crm.model.AppUser;
import ch.zli.hoeshi.crm.model.Garage;
import ch.zli.hoeshi.crm.service.AutoService;
import ch.zli.hoeshi.crm.service.GarageService;
import ch.zli.hoeshi.crm.service.UserService;

@RestController()
@RequestMapping("rest/v1/autos")
public class AutoController {
	
	@Autowired
	private AutoService autoService;
	@Autowired
	private UserService userService;
	@Autowired
	private GarageService garageService;
	
	@GetMapping("")
	List<AutoDto> getAllAutos() {
		return autoService.getAllAutos()
			.stream()
			.map(auto -> new AutoDto(auto))
			.collect(Collectors.toList());
	}
	
	@PostMapping("")
	AutoDto insertAuto(@RequestBody  AutoInputDto autoInput) {
		AppUser mieter = userService.getUserById(autoInput.mieterId);
		Garage garage = garageService.getGarageById(autoInput.garageId);
		return new AutoDto(
				autoService.addAuto(
						autoInput.name, 
						autoInput.kennzeichen, 
						mieter,
						garage)
			);
	}
}

