package pl.inome.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inome.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    @Autowired
    public ProductService() {
        products = new ArrayList<>();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void showProducts() {
        products.forEach(System.out::println);
    }

}
