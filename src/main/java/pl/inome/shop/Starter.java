package pl.inome.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.inome.shop.model.Product;
import pl.inome.shop.service.ProductService;
import pl.inome.shop.utils.PriceGenerator;

import java.math.BigDecimal;
import java.util.List;


@Component
public class Starter implements CommandLineRunner {

    private ProductService productService;
    private PriceGenerator priceGenerator;

    @Autowired
    public Starter(ProductService productService, PriceGenerator priceGenerator) {
        this.productService = productService;
        this.priceGenerator = priceGenerator;
    }

    @Override
    public void run(String... args) {
        System.out.println("--- Shop started ---");

        productService.addProduct(new Product("P1", priceGenerator.randomPrice()));
        productService.addProduct(new Product("P2", priceGenerator.randomPrice()));
        productService.addProduct(new Product("P3", priceGenerator.randomPrice()));
        productService.addProduct(new Product("P4", priceGenerator.randomPrice()));
        productService.addProduct(new Product("P5", priceGenerator.randomPrice()));

        productService.showProducts();
        System.out.println("Added products count: " + productService.getProducts().stream().count());

        List<Product> products = productService.getProducts();

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        System.out.println("Total price = " + totalPrice);


    }
}


