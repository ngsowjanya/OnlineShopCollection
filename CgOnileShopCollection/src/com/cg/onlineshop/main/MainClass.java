package com.cg.onlineshop.main;
import java.util.ArrayList;
import java.util.List;

import com.cg.onlineshop.Product;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.services.ProductService;
import com.cg.onlineshop.services.ProductServiceImpl;
public class MainClass {
	public static void main(String[] args) {
		
		 try {	
			ProductService service =  new ProductServiceImpl();
			//1)accept new Product details 
			Product product = new Product(15000,4,"Good product to have it" , "Dell Laptop");
			product= service.acceptProductDetails(product);
			System.out.println(product);	
			
			//2,searching for product
			int productId1 = 101;
			Product product2;
			product2 = service.getProductDetails(productId1);
		    System.out.println("Product deatils found:- "+product2);
		    
		    //3) Removing product 
		     int productId3 = 101;
		     boolean value = service.removeProdcutDetails(productId3);
		     System.out.println("Product has been removed: "+ value);
		     
		    //4) Accepting Bulk Product details
		     
		     Product product10 = new Product(18000,5,"Best product to have it" , "Lenovo Laptop");
		     Product product11 = new Product(19000,3,"Optimum product to have it" , "Asus Laptop");
		     Product product12 = new Product(14000,5,"the last product to have it" , "HP Pavilion");
		     
		     ArrayList<Product> bulkProductAccept = new ArrayList<Product>();
		     bulkProductAccept.add(product10);
		     bulkProductAccept.add(product11);
		     bulkProductAccept.add(product12);
		     
		     service.acceptBulkProductsDetails(bulkProductAccept);
		     
		     //5) Getting details of all the products
		     List<Product> productList;
		     productList = service.getAllProductDetails();
		     System.out.println(productList);
		     
				
			} catch (ProductDetailsNotFoundException e) {
				e.printStackTrace();
			}
			
			
		
	}
}