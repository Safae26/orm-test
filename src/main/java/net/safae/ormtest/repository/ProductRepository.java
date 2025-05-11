package net.safae.ormtest.repository;

import net.safae.ormtest.entities.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainsIgnoreCase(String kw);
    List<Product> findByNameContainsAndPriceGreaterThan(String kw, double price);
    @Query("select p from Product p where p.name like :x and p.price>:y")
    List<Product> search(@Param("x") String kw, @Param("y") double price);
}
