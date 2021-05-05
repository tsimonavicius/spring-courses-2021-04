package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Andrius Baltrunas
 */
@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;
    @Mock
    private View view;

    @InjectMocks
    private ProductsController productsController;

    @BeforeEach
    public void setUp() {
        mockMvc = standaloneSetup(productsController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setSingleView(view)
                .build();
    }

    @Test
    public void testFindProductByNameWhenProductExist() throws Exception {
        Product product = new Product();
        product.setName("samsung");

        when(productService.getByName(eq("samsung"))).thenReturn(product);

        mockMvc.perform(get("/public/products/findByName")
                .param("name", product.getName()))
                .andExpect(status().isOk())
                .andExpect(view().name("product"))
                .andExpect(model().attribute("product", product));
    }

    @Test
    public void testGetProductsWhenProductsNotExist() throws Exception {
        when(productService.getProductsPaginated(any(Pageable.class))).thenReturn(Page.empty());

        mockMvc.perform(get("/public/products")
                .param("size", "10")
                .param("sort", "price"))
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(model().attribute("productsPage", Page.empty()));
    }

}
