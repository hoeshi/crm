package ch.zli.hoeshi.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.zli.hoeshi.crm.model.AppUser;
import ch.zli.hoeshi.crm.model.Auto;
import ch.zli.hoeshi.crm.model.AutoImpl;
import ch.zli.hoeshi.crm.model.Garage;

public interface AutoRepository extends CrudRepository<AutoImpl, Long> {

	default Auto insertAuto(String name, Integer kennzeichen, AppUser mieter, Garage garage) {
		return save(new AutoImpl(null, name, kennzeichen, mieter, garage));
	}
	
	@Query
	Optional<Auto> findByName(String name);
}
