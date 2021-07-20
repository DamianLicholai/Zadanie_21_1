package com.example.zadanie_21_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String list(Model model, @RequestParam(required = false, name = "kategoria") ProductCategory category) {
        List<Product> products;

        if (category != null) {
            products = productRepository.findByCategory(category);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);

        double sum = 0;

        for (Product product : products) {
            sum += product.getPrice();
        }

        model.addAttribute("priceSum", sum);


        return "product.html";
    }

    @PostMapping("/dodaj")
    public String add(@RequestParam String name, @RequestParam double price, @RequestParam ProductCategory category) {

        Product product = new Product(name, price, category);
        productRepository.add(product);

        return "redirect:/lista";
    }

}


