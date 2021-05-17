package lt.codeacadamy.shop.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lt.codeacadamy.shop.api.Endpoint;
import lt.codeacadamy.shop.api.entity.Product;
import lt.codeacadamy.shop.api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping(Endpoint.API_ROOT + Endpoint.PRODUCTS)
@Api(tags = "This is Product controller")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all product", tags = "getProducts", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = Endpoint.PRODUCT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get product", tags = "getProduct", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    public Product getProduct(@PathVariable(Endpoint.UUID) UUID uuid) {
        return productService.getProduct(uuid);
    }

    @GetMapping(value = Endpoint.PRODUCT_BY_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get product by name", tags = "getProduct", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    public Product getProductByName(@PathVariable String name) {
        return productService.getByName(name);
    }

    @GetMapping(value = Endpoint.SEARCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search products by name or description", tags = "searchProducts", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazina produktus"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    public List<Product> searchProducts(@RequestParam String query) {
        return productService.findProducts(query);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create product", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Kai sekmingai sukuriamas produktas"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
    }
}
