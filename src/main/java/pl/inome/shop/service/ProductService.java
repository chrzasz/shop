package pl.inome.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inome.shop.domain.Product;
import pl.inome.shop.repository.CartRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    CartRepository products;

    @Autowired
    public ProductService(CartRepository products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.getAllProducts());
    }

    public void addProduct(Product product) {
        products.createProduct(product);
    }

    public BigDecimal getCartTotalPrice() {
        return BigDecimal.valueOf(0);
    }

}
