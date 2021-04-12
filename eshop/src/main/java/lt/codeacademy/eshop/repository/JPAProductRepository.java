package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAProductRepository extends JpaRepository<Product, String> {
}
