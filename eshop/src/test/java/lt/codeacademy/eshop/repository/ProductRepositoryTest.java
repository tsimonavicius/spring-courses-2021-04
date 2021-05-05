package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrius Baltrunas
 */
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateNewProduct() {
        Product product = new Product();
        product.setName("vienaragis");
        product.setPrice(BigDecimal.valueOf(25.5));
        product.setDescription("Vienaragio ragas");
        product.setQuantity(1);

        entityManager.persist(product);

        List<Product> products = productRepository.findByName("vienaragis");

        assertEquals(1, products.size());
        assertEquals("vienaragis", products.get(0).getName());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productRepository.findAll();

        assertEquals(15, products.size());
    }
}
