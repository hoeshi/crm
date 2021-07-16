package ch.zli3.ksh18a.crm.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli3.ksh18a.crm.repository.UserRepository;

@Component
public class Initializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.addUser("max", "max123");
        userRepository.addUser("maks", "maks123");
        userRepository.addUser("maggs", "maggs123");
        userRepository.addUser("macks", "macks123");
    }

}
