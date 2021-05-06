package lt.codeacadamy.shop.api.controller;

import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.entity.Product;
import lt.codeacadamy.shop.api.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping(Endpoint.API_ROOT + Endpoint.PRODUCTS)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = Endpoint.PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable(Endpoint.UUID) UUID uuid) {
        return productService.getProduct(uuid);
    }

    @GetMapping(value = Endpoint.PRODUCT_BY_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductByName(@PathVariable String name) {
        return productService.getByName(name);
    }
}
