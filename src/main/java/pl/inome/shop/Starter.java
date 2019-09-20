package pl.inome.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.inome.shop.model.Product;
import pl.inome.shop.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class Starter implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public Starter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("--- Shop started ---");

        productRepository.build();

        System.out.println(productRepository.getAllProducts());


        System.out.println("Added products count: " + productRepository.getAllProducts().stream().count());

        List<Product> products = productRepository.getAllProducts().stream().collect(Collectors.toList());

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        System.out.println("Total price = " + totalPrice);


    }
}


