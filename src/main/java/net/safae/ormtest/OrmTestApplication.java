package net.safae.ormtest;

import net.safae.ormtest.entities.Product;
import net.safae.ormtest.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.List;


@SpringBootApplication
public class OrmTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmTestApplication.class, args);
    }


    @Bean /// S'exécute au démarrage
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> { // Expression Lambda
            Product p = Product.builder().name("Computer").price(10000).quantity(100).build();
            productRepository.save(p);
            productRepository.save(Product.builder().name("Printer").price(500).quantity(50).build());
            productRepository.save(Product.builder().name("Headphone").price(200).quantity(200).build());
            List<Product> products = productRepository.findByNameContainsIgnoreCase("M");
            products.forEach(prod->{
                System.out.println(prod.toString());
                    }
                    );


        };
    }

}