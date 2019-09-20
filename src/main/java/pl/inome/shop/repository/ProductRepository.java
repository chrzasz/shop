package pl.inome.shop.repository;


import pl.inome.shop.model.Product;

import java.util.Collection;

public interface ProductRepository {

    void createProduct(Product product);

    Collection<Product> getAllProducts();

    Product getProduct(String name);

    void deteleProduct(String name);

    void build();

}
