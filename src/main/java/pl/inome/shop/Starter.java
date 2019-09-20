package pl.inome.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Starter implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("--- Shop started ---");
    }
}

