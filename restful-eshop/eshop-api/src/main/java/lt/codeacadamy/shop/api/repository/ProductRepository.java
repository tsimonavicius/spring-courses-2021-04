package lt.codeacadamy.shop.api.repository;

import lt.codeacadamy.shop.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByName(String name);
    //List<Product> findByNameLikeOrFindByDescription(String name, String description); //"%name%"

}
