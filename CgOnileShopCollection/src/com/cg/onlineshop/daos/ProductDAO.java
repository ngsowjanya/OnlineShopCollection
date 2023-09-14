package com.cg.onlineshop.daos;
import java.util.List;
import java.util.Optional;

import com.cg.onlineshop.Product;
public interface ProductDAO {
	public Product save(Product product);
	public Product update(Product product);
	public boolean delete(int id);
	public List<Product> getAllProducts();
	public Product getAllProduct(int id);
	public Optional<Product> getProduct(int id);
	void insertBulkProducts(List<Product> products);	
}