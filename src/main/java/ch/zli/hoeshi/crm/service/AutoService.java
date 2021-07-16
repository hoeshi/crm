package ch.zli.hoeshi.crm.service;

import java.util.List;

import ch.zli.hoeshi.crm.model.AppUser;
import ch.zli.hoeshi.crm.model.Auto;
import ch.zli.hoeshi.crm.model.Garage;

public interface AutoService {

	List<Auto> getAllAutos();
	
	Auto addAuto(String name, Integer kennzeichen, AppUser mieter, Garage garage);
	
}
