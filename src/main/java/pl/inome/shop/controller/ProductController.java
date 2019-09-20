package pl.inome.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.inome.shop.model.Product;
import pl.inome.shop.repository.ProductRepository;

import java.util.Collection;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public Collection<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
