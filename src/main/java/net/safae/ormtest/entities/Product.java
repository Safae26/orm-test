package net.safae.ormtest.entities;

import jakarta.persistence.*;
import jakarta.annotation.*;
import lombok.*;

@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // Incrémentation avec 1
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
