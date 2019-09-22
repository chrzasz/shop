package pl.inome.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.inome.shop.model.Product;
import pl.inome.shop.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Profile("pro")
public class ProductProController {

    private ProductService productService;

    @Value("${shop-price.vat}")
    private int vat;
    @Value("${shop-price.discount}")
    private int discount;

    @Autowired
    public ProductProController(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getAllProductsWithTotalPrice() {
        System.out.println(productService.getAllProducts());
        System.out.println("\r\nProducts with VAT " + vat + "% :");
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

        System.out.println("\r\nProducts with VAT " + vat + " and discount " + discount + "% :");
        List<Product> productsWithVatAndDiscount;
        productsWithVatAndDiscount = productsWithVat;

        for (int i = 0; i < productsWithVatAndDiscount.size(); i++) {
            Product p = productsWithVatAndDiscount.get(i);
            BigDecimal priceWithVatAndDiscount = p.getPrice().subtract(p.getPrice().multiply(BigDecimal.valueOf(discount / 100d)));
            productsWithVatAndDiscount.set(i, new Product(p.getName(), priceWithVatAndDiscount.setScale(2, BigDecimal.ROUND_HALF_UP)));
        }

        productsWithVatAndDiscount.forEach(System.out::println);

        totalPrice = BigDecimal.ZERO;
        for (Product product : productsWithVatAndDiscount) {
            totalPrice = totalPrice.add(product.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        System.out.println("Total Price: " + totalPrice);


    }


}
