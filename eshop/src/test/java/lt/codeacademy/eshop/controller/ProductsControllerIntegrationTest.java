package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.MessageService;
import lt.codeacademy.eshop.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Andrius Baltrunas
 */
@WebMvcTest(ProductsController.class)
public class ProductsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private MessageService messageService;

    @MockBean
    @Qualifier("productServiceImpl")
    private ProductService productService;

    @Test
    public void testGetProductsWhenOneProductExist() throws Exception {
        Product product = new Product(null, "vienaragis", 1, BigDecimal.valueOf(25.5), "Vienaragio descriptionas");
        Page<Product> page = new PageImpl<>(List.of());

        Mockito.when(productService.getProductsPaginated(ArgumentMatchers.any(Pageable.class))).thenReturn(page);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/public/products")
                .param("size", "15"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("products"))
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();

        Assertions.assertNotNull(modelAndView);
        Map<String, Object> model = modelAndView.getModel();

        Page<Product> result = (Page<Product>) model.get("productsPage");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(page, result);
    }
}
