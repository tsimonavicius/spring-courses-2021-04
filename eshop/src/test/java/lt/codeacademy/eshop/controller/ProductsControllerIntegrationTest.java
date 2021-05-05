package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
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
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author Andrius Baltrunas
 */
@WebMvcTest(ProductsController.class)
@WithMockUser(roles = "{ADMIN}")
public class ProductsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataSource dataSource;

    @MockBean
    @Qualifier("productServiceImpl")
    private ProductService productService;

    //TODO fix this test
   // @Test
    public void testGetProductsWhenOneProductExist() throws Exception {
        Page<Product> page = new PageImpl<>(List.of(new Product()));

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
