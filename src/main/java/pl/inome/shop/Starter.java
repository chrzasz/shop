package pl.inome.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.inome.shop.repository.CartRepository;


@Component
public class Starter implements CommandLineRunner {

    private CartRepository cartRepository;

    @Autowired
    public Starter(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("--- Shop started ---");
        cartRepository.build();
        System.out.println("Added products count: " + cartRepository.getAllProducts().size());
    }
}



