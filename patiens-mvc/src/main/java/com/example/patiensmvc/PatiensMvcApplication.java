package com.example.patiensmvc;

import com.example.patiensmvc.entities.Patients;
import com.example.patiensmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatiensMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatiensMvcApplication.class, args);
    }

    @Bean  //pour executer la methode automatiquement
    CommandLineRunner commandLineRunner (PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patients(null, "Ahmed", new Date(), true, 421));
            patientRepository.save(new Patients(null, "Yassine", new Date(), false, 474));
            patientRepository.save(new Patients(null, "Mounir", new Date(), false, 320));
            patientRepository.save(new Patients(null, "Oussama", new Date(), true, 987));
            patientRepository.findAll().forEach(patients -> {
                System.out.println(patients.getNom());
            });
        };
    }
}
