package ma.firsrapp.university.repository;

import ma.firsrapp.university.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository <product,Long > {

    //get an or multi objects by a keyword
    List<product> findByNameContains(String k);
}
