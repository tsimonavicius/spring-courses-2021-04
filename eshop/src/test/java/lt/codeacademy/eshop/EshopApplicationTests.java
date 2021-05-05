package lt.codeacademy.eshop;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(roles = "{ADMIN}")
class EshopApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/public/products/create")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .content(EntityUtils.toString(new UrlEncodedFormEntity(
                        List.of(new BasicNameValuePair("name", "Vienaragis"),
                                new BasicNameValuePair("price", "55.5"),
                                new BasicNameValuePair("quantity", "2"),
                                new BasicNameValuePair("description", "Kazkoks vienaragis"))))
                ).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        List<Product> products = productRepository.findByName("Vienaragis");

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("Vienaragis", products.get(0).getName());
    }

    //@Test
    void contextLoads() {
    }

}
