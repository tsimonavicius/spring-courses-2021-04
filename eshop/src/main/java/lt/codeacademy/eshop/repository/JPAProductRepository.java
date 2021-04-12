package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAProductRepository extends JpaRepository<Product, String> {

    List<Product> findByName(String name);
}
