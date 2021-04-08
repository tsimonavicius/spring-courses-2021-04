package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Product;

import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
public interface ProductService
{
	void addProduct(Product product);

	Product getProduct(UUID uuid);
}
