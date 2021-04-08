package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController
{

	private final ProductService productService;

	public ProductsController(@Qualifier("productServiceImpl") ProductService productService)
	{
		this.productService = productService;
	}

	@GetMapping("/create")
	public String openCreateProductForm(Model model)
	{
		model.addAttribute("product", new Product());
		return "product";
	}

	@PostMapping("/create")
	public String createProduct(Product product, Model model)
	{
		model.addAttribute("product", new Product());
		model.addAttribute("success", "Product save successfully");

		productService.addProduct(product);

		return "product";
	}

}
