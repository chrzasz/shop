package pl.inome.shop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.inome.shop.model.Product;
import pl.inome.shop.utils.PriceGenerator;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductStartRepository implements ProductRepository {

    Map<String, Product> products = new HashMap<>();

    PriceGenerator priceGenerator;

    public ProductStartRepository() {
    }

    @Autowired
    public ProductStartRepository(PriceGenerator priceGenerator) {
        this.priceGenerator = priceGenerator;
    }

    @Override
    public void createProduct(Product product) {
        products.put(product.getName(), product);
    }

    @Override
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    @Override
    public Product getProduct(String name) {
        return products.get(name);
    }

    @Override
    public void deteleProduct(String name) {
        products.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createProduct(new Product("P1", priceGenerator.randomPrice()));
        createProduct(new Product("P2", priceGenerator.randomPrice()));
        createProduct(new Product("P3", priceGenerator.randomPrice()));
        createProduct(new Product("P4", priceGenerator.randomPrice()));
        createProduct(new Product("P5", priceGenerator.randomPrice()));
    }

}
