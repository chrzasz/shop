package pl.inome.shop.repository;


import pl.inome.shop.model.Product;

import java.util.List;

public interface CartRepository {

    void createProduct(Product product);

    List<Product> getAllProducts();

    void build();

}
