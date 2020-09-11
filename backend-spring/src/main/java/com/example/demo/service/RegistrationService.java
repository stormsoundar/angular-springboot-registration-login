package com.example.demo.service;

import com.example.demo.controller.RegisterController;
import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    RegistrationRepository registrationRepository;

    // Create
    public Registration createRegister(Registration registration) {
        return registrationRepository.save(registration);
    }
//
//    public Registration findByUsernameAndPassword(String username, String password) {
//        return registrationRepository.findByUserNameAndPassword(username, password);
//    }

//    public Registration findByUsernameAndPassword(Registration registration) {
//       final String username = null;
//       final String password = null;
//        return registrationRepository.findByUserNameAndPassword(username, password);
//    }

//    @Override
    public Registration findByUsernameAndPassword(Registration registration) {
        log.debug("Request to save Registration : {}", registration);
        final String username = registration.getUsername();
        final String password = registration.getPassword();
        Registration result = null;
        if(username != null && password != null) {
            result = registrationRepository.findByUsernameAndPassword(username, password);
        }
        return result;
    }
}
