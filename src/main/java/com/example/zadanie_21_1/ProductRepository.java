package com.example.zadanie_21_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Masło", 4.2, ProductCategory.FOOD));
        products.add(new Product("Mleko", 2.2, ProductCategory.FOOD));
        products.add(new Product("Chleb", 4.99, ProductCategory.FOOD));
        products.add(new Product("Pralka", 1049.99, ProductCategory.AGD));
        products.add(new Product("Zlew", 661.59, ProductCategory.AGD));
        products.add(new Product("Opona", 242.29, ProductCategory.OTHER));
        products.add(new Product("Telefon", 542.00, ProductCategory.OTHER));
    }


    public List<Product> findByCategory(ProductCategory category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }


}
