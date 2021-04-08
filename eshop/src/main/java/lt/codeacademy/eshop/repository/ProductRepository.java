package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Repository
public class ProductRepository {
    private final Map<UUID, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public void save(Product product) {
        products.put(product.getUuid(), product);
    }

    public Product getProduct(UUID uuid) {
        return products.get(uuid);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void update(Product product) {
        products.put(product.getUuid(), product);
    }

    public void delete(UUID uuid) {
        products.remove(uuid);
    }
}
