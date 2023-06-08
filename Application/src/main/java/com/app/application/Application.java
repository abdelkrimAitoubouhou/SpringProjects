package com.app.application;

import com.app.application.Repository.ClientRepository;
import com.app.application.Repository.ProductRepository;
import com.app.application.entities.Client;
import com.app.application.entities.Product;
import jakarta.persistence.GeneratedValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private ProductRepository productRepository;
    private ClientRepository clientRepository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.save(new Product(1, "Computer", 4500, 3));
        productRepository.save(new Product(2, "Smartphone", 3400, 4));
        productRepository.save(new Product(3, "Printer", 5000, 2));
        clientRepository.save(new Client(2, "Aitoubouhou", "Abdelkrim", "G772659" ));

        System.out.println("---------------------------Facture---------------------------------");
        Client client = clientRepository.findById(Long.valueOf(2)).get();
        System.out.println("Nom : " + client.getNom());
        System.out.println("Prenom : " + client.getPrenom());
        System.out.println(("CIN : " + client.getCin()));


    }

}
