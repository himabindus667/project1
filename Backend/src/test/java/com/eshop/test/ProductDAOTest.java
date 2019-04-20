package com.eshop.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.dao.ProductDAO;
import com.eshop.model.Product;

public class ProductDAOTest
{
	static ProductDAO productDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.eshop");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
    @Ignore
    @Test
	public void addProductTest()
	{
		Product product=new Product();
	    product.setProName("Kurthis");
	    product.setProprice(2000);
	    product.setProDesc("Cotton");
	    product.setStock(20);
	    product.setCategoryID(2);
	    product.setSupplierId(4);
	    
		assertTrue("Problem in adding the Product",productDAO.addProduct(product));
		
		
	}
	
	
    @Ignore
	@Test
	public void deleteProductTest()
	{
		Product product= productDAO.getProduct(15);
		assertTrue("Problem in deleting the Product",productDAO.deleteProduct(product));
		
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(17);
		product.setProprice(900);
		product.setStock(50);
		assertTrue("Problem in updating the Product",productDAO.updateProduct(product));
	}
	
	
    @Test
	public void listProductsTest()
	{
	
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in Retreiving the Products",listProducts.size()>0);
		for(Product product:listProducts)
    	{
			System.out.print(product.getProName()+ "   ");
			System.out.print(product.getProDesc()+ "   ");
			System.out.print(product.getStock()+ "   ");
			System.out.println(product.getProprice()+ "   ");
			
		}
	
	}
	
	

}
