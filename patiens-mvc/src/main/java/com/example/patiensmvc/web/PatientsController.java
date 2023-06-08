package com.example.patiensmvc.web;

import com.example.patiensmvc.entities.Patients;
import com.example.patiensmvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@AllArgsConstructor
public class PatientsController {
    private PatientRepository patientRepository;
    //Code Before Pagination
//@GetMapping(path = "/index") //pour acceder a cette methode il faut suivre localhost par /index
//
//    public String Patients (Model model){  //Mvc model
//    List<Patients> patients = patientRepository.findAll();
//    model.addAttribute("ListPatients", patients);
//    return "patients"; // patients est une page ou une view html (il faut cree une page html qui s'appelle patients.html)
//
//    }



    //Code After Pagination
    @GetMapping(path = "/index") //pour acceder a cette methode il faut suivre localhost par /index

    public String Patients (Model model,  //Mvc model
                            @RequestParam(value = "page", defaultValue = "0") int page, //page = est l'indice de la page qu'on veut l'afficher (start with 0)
                            @RequestParam(value = "size", defaultValue = "5") int size){  //size = nomre de colone qu'on va l'afficher
        Page<Patients> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("ListPatients", pagePatients);
        return "patients"; // patients est une page ou une view html (il faut cree une page html qui s'appelle patients.html)

    }

}
