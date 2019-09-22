package pl.inome.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.inome.shop.model.Product;
import pl.inome.shop.service.ProductService;

import java.math.BigDecimal;

@Controller
@Profile("start")
public class ProductStartController {

    private ProductService productService;

    @Autowired
    public ProductStartController(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProductsWithTotalPrice() {
        System.out.println(productService.getAllProducts());
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : productService.getAllProducts()) {
            totalPrice = totalPrice.add(product.getPrice());
        }

        System.out.println("Total Price: " + totalPrice);

    }
}
