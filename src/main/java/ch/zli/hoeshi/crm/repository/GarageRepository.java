package ch.zli.hoeshi.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ch.zli.hoeshi.crm.model.Garage;
import ch.zli.hoeshi.crm.model.GarageImpl;

public interface GarageRepository extends CrudRepository<GarageImpl, Long>{
	
	default Garage insertGarage(String name, String ort) {
		return save(new GarageImpl(null, name, ort));
		
	}

	@Query
	Optional<Garage> findByName(String name);
}
