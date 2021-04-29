package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrius Baltrunas
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private Product product;
    @Mock
    private Pageable pageable;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testGetProductsWhenProductsNotExist() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<Product> products = productService.getProducts();

        assertNotNull(products);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testGetProductsWhenProductsExists() {
        when(productRepository.findAll()).thenReturn(List.of(product));

        List<Product> products = productService.getProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
    }

    @Test
    public void testAddProductWhenProductIsNull() {
        productService.addProduct(null);

        verify(productRepository, times(0)).save(eq(null));
    }

    @Test
    public void testAddProduct() {
        when(productRepository.save(product)).thenReturn(product);

        productService.addProduct(product);

        verify(productRepository, times(1)).save(product);
    }



    /*private Product getFakeProduct(){
        return new Product();
    }*/
}
