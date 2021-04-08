package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Service
public class ProductServiceImpl implements ProductService
{
	private static final int MAX_COUNT = 10;

	private final ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public void addProduct(Product product)
	{
		int count = 0;
		while(MAX_COUNT >= count)
		{
			UUID uuid = UUID.randomUUID();
			Product p = getProduct(uuid);
			if(p == null)
			{
				product.setUuid(uuid);
				repository.save(product);
				break;
			}

			count++;
		}
	}

	@Override
	public Product getProduct(UUID uuid)
	{
		return repository.getProduct(uuid);
	}
}
