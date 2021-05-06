package lt.codeacadamy.shop.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacadamy.shop.api.entity.Product;
import lt.codeacadamy.shop.api.exception.ProductNotFoundException;
import lt.codeacadamy.shop.api.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Andrius Baltrunas
 */
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        try {
            if (product == null) {
                return;
            }
            productRepository.save(product);
        } catch (IllegalArgumentException e) {
            log.error("Cannot create product {}", product);
        }
    }

    public Product getProduct(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id.toString()));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    public Product getByName(String name) {
        return productRepository.findByName(name).get(0);
    }

    public Page<Product> getProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    //TODO think about Query or JPA
    public List<Product> findProducts(String query) {

        if (query == null || query.length() == 0) {
            return Collections.emptyList();
        }

        return productRepository.findAll().stream()
                .filter(findByQuery(query))
                .collect(Collectors.toList());
    }

    private Predicate<Product> findByQuery(String query) {
        return p -> p.getName().contains(query) || p.getDescription().contains(query);
    }
}
