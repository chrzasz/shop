package pl.inome.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.inome.shop.domain.Product;
import pl.inome.shop.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Profile("plus")
public class ProductPlusController {

    private ProductService productService;

    @Value("${shop-price.vat}")
    private int vat;

    @Autowired
    public ProductPlusController(ProductService productService) {
        this.productService = productService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void getAllProductsWithTotalPrice() {
        System.out.println(productService.getAllProducts());
        System.out.println("\r\nProducts with VAT " + vat + "%");
        List<Product> productsWithVat;
        productsWithVat = productService.getAllProducts();

        for (int i = 0; i < productsWithVat.size(); i++) {
            Product p = productsWithVat.get(i);
            BigDecimal priceWithVat = p.getPrice().add(p.getPrice().multiply(BigDecimal.valueOf(vat / 100d)));
            productsWithVat.set(i, new Product(p.getName(), priceWithVat.setScale(2, BigDecimal.ROUND_HALF_UP)));
        }

        productsWithVat.forEach(System.out::println);

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : productsWithVat) {
            totalPrice = totalPrice.add(product.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        System.out.println("Total Price: " + totalPrice);


    }


}
