package pl.inome.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.inome.shop.model.Product;
import pl.inome.shop.repository.CartRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private CartRepository products;

    @Autowired
    public ProductService(CartRepository products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products.getAllProducts();
    }

    public void addProduct(Product product) {
        products.createProduct(product);
    }

    public BigDecimal getCartTotalPrice() {
        return BigDecimal.valueOf(0);
    }

}
