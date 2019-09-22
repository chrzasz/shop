package pl.inome.shop.repository;

import pl.inome.shop.domain.Product;

import java.util.Collection;

public interface ProductRepository {

    void createProduct(Product product);

    Collection<Product> getAllProducts();

    void build();

}
