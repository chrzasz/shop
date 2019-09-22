package pl.inome.shop.repository;

import org.springframework.stereotype.Repository;
import pl.inome.shop.model.Product;
import pl.inome.shop.utils.PriceGenerator;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Cart implements CartRepository {

    private Map<String, Product> products = new HashMap<>();

    private PriceGenerator priceGenerator;

    public Cart() {
    }

    public Cart(Map<String, Product> products, PriceGenerator priceGenerator) {
        this.products = products;
        this.priceGenerator = priceGenerator;
    }


    @Override
    public void createProduct(Product product) {
        products.put(product.getName(), product);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
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
