package com.testing.test.web;

import com.testing.test.Repository.ClientRepository;
import com.testing.test.Repository.ProductRepository;
import com.testing.test.entities.Client;
import com.testing.test.entities.Facture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitController {
    private ProductRepository productRepository;
    private ClientRepository clientRepository;

    @GetMapping(path = "/index")
    public String produit (Model model1, Model model2){
        List<Facture> produits = productRepository.findAll();
        model1.addAttribute("ProductList", produits);

        List<Client> clients = clientRepository.findAll();
        model2.addAttribute("ClientList", clients);

        return "facture";
    }
}


