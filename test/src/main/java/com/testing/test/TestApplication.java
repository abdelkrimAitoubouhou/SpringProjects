package com.testing.test;

import com.testing.test.Repository.ClientRepository;
import com.testing.test.Repository.ProductRepository;
import com.testing.test.entities.Client;
import com.testing.test.entities.Facture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {
    private Client client;

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }



@Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, ProductRepository productRepository){
        return args -> {
            clientRepository.save(new Client(2, "Aitoubouhou", "Abdelkrim", "G772659" ));
            System.out.println("");
            System.out.println("");
            System.out.println("-------------------------- Facture ---------------------------");
            System.out.println("");
            clientRepository.findAll().forEach(client1 -> {
                System.out.println("Nom    : " + client1.getNom());
                System.out.println("Prenom : " +client1.getPrenom());
                System.out.println("Cin    : " +client1.getCin());;
            });
                System.out.println("");
                System.out.println("-------------------------- Produits ---------------------------");
                System.out.println("");
            productRepository.save(new Facture(1, "Computer  ", 4500, 3));
            productRepository.save(new Facture(2, "Smartphone", 3400, 4));
            productRepository.save(new Facture(3, "Printer   ", 5000, 2));
            System.out.println("id" + "      nom" + "        quantité" + "      prix");
            System.out.println("");
            productRepository.findAll().forEach(produit -> {
                System.out.println(produit.getId() + "      "+ produit.getNom()+ "      " + produit.getQuantite()+ "      " + produit.getPrice());
                System.out.println("");
            });
        };
    }






}
