package ch.zli.hoeshi.crm.service;

import java.util.List;

import ch.zli.hoeshi.crm.model.Garage;

public interface GarageService {
	
	List<Garage> getAllGarage();
	
	Garage addGarage(String name, String ort);
	
	Garage findByName(String name);
	
	Garage getGarageById(long garageId);
	
	

}
