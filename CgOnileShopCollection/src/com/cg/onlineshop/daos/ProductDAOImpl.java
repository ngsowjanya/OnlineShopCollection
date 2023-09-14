 package com.cg.onlineshop.daos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.cg.onlineshop.Product;
import com.cg.onlineshop.utills.DBUtil;
public class ProductDAOImpl implements ProductDAO{

	@Override
	public Product save(Product product) {				
		product.setId(DBUtil.ID_COUNTER++);
		DBUtil.productsDB.put(product.getId(), product);
		return product;
	}
	@Override
	public Product update(Product product) {
		return null;
	}
	@Override
	public boolean delete(int id) {
		Product product = DBUtil.productsDB.remove(id);
		return (product != null);
	}

	@Override
	public List<Product> getAllProducts() {
		ArrayList<Product> allProductList = new ArrayList<>();
		Collection<Product> products = DBUtil.productsDB.values();
		for(Product product: products) {
		allProductList.add(product);
		}
		return allProductList;
	}

	@Override
	public Product getAllProduct(int id) {
		return DBUtil.productsDB.get(id);
	}

	@Override
	public void insertBulkProducts(List<Product> products) {
		for(Product product: products) {
			product.setId(DBUtil.ID_COUNTER++);
			DBUtil.productsDB.put(product.getId(), product);
		}
	}
	@Override
	public Optional<Product> getProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product> optional =Optional.ofNullable(DBUtil.productsDB.get(id));
		return optional;
	}
}