package com.example.demo.controller;

import com.example.demo.entity.Registration;
import com.example.demo.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

//import com.codahale.metrics.annotation.Timed;

@RestController
public class RegisterController {

    private final Logger log = (Logger) LoggerFactory.getLogger(RegisterController.class);

    private static final String ENTITY_NAME = "registration";

    @Autowired
    private RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Registration createRegister(@RequestBody Registration registration) {
        return registrationService.createRegister(registration);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Registration getRegistration(@RequestBody Registration registration) throws Exception {
        log.debug("REST request to save Registration: {}", registration);
        if (registration.getId() != null) {
            throw new Exception("A new userDetails cannot already have an ID\", ENTITY_NAME, \"idexists\"");
        }
        Registration result = null;
        if(!ObjectUtils.isEmpty(registration)) {
            result = registrationService.findByUsernameAndPassword(registration);
        }
        return result;
    }

//      @CrossOrigin(origins = "http://localhost:4200")
//      @RequestMapping(value = "/login", method = RequestMethod.GET)
//      public ResponseEntity<Object> getUserByUsernameAndPassword (@PathVariable String username, String password)
//              throws Exception {
//        Registration registration = (com.example.demo.entity.Registration) registrationService.findByUsernameAndPassword(username, password);
//             //   .orElseThrow(() -> new Exception("User not found"));
//        return ResponseEntity.ok().body(Registration);
//      }

}
