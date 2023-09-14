package com.cg.onlineshop.services;
import java.util.List;
import com.cg.onlineshop.Product;
import com.cg.onlineshop.daos.ProductDAO;
import com.cg.onlineshop.daos.ProductDAOImpl;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;

public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO = new ProductDAOImpl();

	@Override
	public Product acceptProductDetails(Product product) {
		product = productDAO.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProductDetails()  {
		List<Product> AllProductList = productDAO.getAllProducts();
		return AllProductList;
	}

	@Override
	public Product getProductDetails(int id) throws ProductDetailsNotFoundException {
		
		return productDAO.getProduct(id).orElseThrow(()-> new ProductDetailsNotFoundException("Product details not fpund:- "+ id));
	}

	@Override
	public void acceptBulkProductsDetails(List<Product> products) {	
		productDAO.insertBulkProducts(products);
	}

	@Override
	public boolean removeProdcutDetails(int id) {
		boolean delete = productDAO.delete(id);
		return delete;
	}

}
