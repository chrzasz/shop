package pl.inome.shop.service;

import org.springframework.stereotype.Service;
import pl.inome.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {

        Product product1 = new Product("P1");
        Product product2 = new Product("P2");
        Product product3 = new Product("P3");
        Product product4 = new Product("P4");
        Product product5 = new Product("P5");

        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

    }

    public List<Product> getProducts() {
        return products;
    }

}
