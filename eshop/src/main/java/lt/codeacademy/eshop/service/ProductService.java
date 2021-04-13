package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
public interface ProductService {
    void addProduct(Product product);

    Product getProduct(UUID uuid);

    List<Product> getProducts();

    void update(Product product);

    void delete(UUID uuid);

    Product getByName(String name);

    Page<Product> getProductsPaginated(Pageable pageable);
}
