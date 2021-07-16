package ch.zli.hoeshi.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.hoeshi.crm.exception.CarAlreadyExistsException;
import ch.zli.hoeshi.crm.exception.InvalidArgumentException;
import ch.zli.hoeshi.crm.model.AppUser;
import ch.zli.hoeshi.crm.model.Auto;
import ch.zli.hoeshi.crm.model.Garage;
import ch.zli.hoeshi.crm.repository.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService {
	
	@Autowired
	AutoRepository repo;
	

	@Override
	public List<Auto> getAllAutos() {
		List<Auto> autos = new ArrayList<>();
		
		for (var auto : repo.findAll()) {
			autos.add(auto);
		}
		return autos;
	}


	@Override
	public Auto addAuto(String name, Integer kennzeichen, AppUser mieter, Garage garage) {
		if(name == null || kennzeichen == null) {
			throw new InvalidArgumentException();
		}
		if(repo.findByName(name).isPresent()) {
			throw new CarAlreadyExistsException();
		}
		
		return repo.insertAuto(name, kennzeichen, mieter, garage);
	}



	
	
}
