package ch.zli3.ksh18a.crm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ch.zli3.ksh18a.crm.model.AppUser;
import ch.zli3.ksh18a.crm.model.AppUserImpl;

public interface UserRepository extends CrudRepository<AppUserImpl, Long> {

    default AppUser addUser(String username, String password) {

        AppUserImpl appUserImpl = new AppUserImpl(username, password);

        return save(appUserImpl);
    }

    Optional<AppUser> findByuserName(String username);
}