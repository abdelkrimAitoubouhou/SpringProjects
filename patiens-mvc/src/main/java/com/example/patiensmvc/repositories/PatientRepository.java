package com.example.patiensmvc.repositories;

import com.example.patiensmvc.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients, Long> {
}
