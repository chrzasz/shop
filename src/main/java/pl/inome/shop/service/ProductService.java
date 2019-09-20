package pl.inome.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inome.shop.model.Product;
import pl.inome.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository products;

    @Autowired
    public ProductService(ProductRepository products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.getAllProducts());
    }

    public void addProduct(Product product) {
        products.createProduct(product);
    }

}
