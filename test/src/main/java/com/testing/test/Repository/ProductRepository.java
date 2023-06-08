package com.testing.test.Repository;

import com.testing.test.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Facture, Long> {

}
