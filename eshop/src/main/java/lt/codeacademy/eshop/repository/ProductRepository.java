package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Repository
public class ProductRepository {
    private final Map<UUID, Product> products;

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        products = new HashMap<>();
    }

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProduct(UUID uuid) {
        return products.get(uuid);
    }

    public List<Product> getProducts() {
        return jdbcTemplate.query("SELECT * FROM Products", new ProductMapper());
    }

    public void update(Product product) {
        products.put(product.getId(), product);
    }

    public void delete(UUID uuid) {
        products.remove(uuid);
    }


    private class ProductMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();

            product.setId(UUID.fromString(rs.getString("id")));
            product.setName(rs.getString("name"));
            product.setQuantity(rs.getInt("quantity"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setDescription(rs.getString("description"));

            return product;
        }
    }
}
