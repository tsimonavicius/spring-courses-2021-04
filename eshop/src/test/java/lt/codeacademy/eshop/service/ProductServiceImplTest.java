package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.exception.ProductNotFoundException;
import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void testGetProductWhenProductNotExist() {
        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.ofNullable(null));

        assertThrows(ProductNotFoundException.class, () -> productService.getProduct(UUID.randomUUID()));
    }

    @Test
    public void testGetProductWhenProductExist() {
        UUID uuid = UUID.randomUUID();
        when(productRepository.findById(uuid)).thenReturn(Optional.of(product));

        Product response = productService.getProduct(uuid);

        assertEquals(product, response);
    }

    @Test
    public void testUpdateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        productService.update(product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteWhenProductNotExist() {
        doThrow(IllegalArgumentException.class).when(productRepository).deleteById(any(UUID.class));

        assertThrows(IllegalArgumentException.class, () -> productService.delete(UUID.randomUUID()));
    }

    @Test
    public void testDeleteProductWhenProductExist() {
        UUID uuid = UUID.randomUUID();
        doNothing().when(productRepository).deleteById(uuid);

        productService.delete(uuid);

        verify(productRepository, times(1)).deleteById(uuid);
    }
}
