package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.JPAProductRepository;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final int MAX_COUNT = 10;

    private final ProductRepository repository;
    private JPAProductRepository jpaProductRepository;


    public ProductServiceImpl(ProductRepository repository, JPAProductRepository jpaProductRepository) {
        this.repository = repository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public void addProduct(Product product) {
        jpaProductRepository.save(product);
    }

    @Override
    public Product getProduct(UUID id) {
        return jpaProductRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> getProducts() {
        return jpaProductRepository.findAll();
    }

    @Override
    public void update(Product product) {
        jpaProductRepository.save(product);
    }

    @Override
    public void delete(UUID id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public Product getByName(String name) {
        return jpaProductRepository.findByName(name).get(0);
    }
}
