package com.example.demo.repository;

import com.example.demo.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

       Registration findByUsernameAndPassword(String username, String password);
//      {
//            return null;
//      }
//     {
//          return registration;
//     }
}
