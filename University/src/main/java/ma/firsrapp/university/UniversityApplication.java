package ma.firsrapp.university;

import ma.firsrapp.university.entities.product;
import ma.firsrapp.university.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    @Autowired
    private productRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new product(1, "Computer", 4300, 3));
        productRepository.save(new product(2, "Printer", 1200, 4));
        productRepository.save(new product(3, "Smartphone", 3200 , 32));


        //showing a liste of objects in console
        List<product> products = productRepository.findAll();
        products.forEach(p-> {
            System.out.println(p.toString());
        });

        //showing an object by his id
        product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("-----------------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("-----------------------");


        //get an or multi objects by a keyword
        List<product> productList = productRepository.findByNameContains("c");
        productList.forEach(product1 ->
                        System.out.println(product1)
                );


    }
}
