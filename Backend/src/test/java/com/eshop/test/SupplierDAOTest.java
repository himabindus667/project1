package com.eshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.dao.SupplierDAO;
import com.eshop.model.Supplier;



public class SupplierDAOTest {

	@Autowired
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.eshop");
	    context.refresh();
	    
	    supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	}
    @Ignore
	@Test
	public void Test()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Pantaloons");
		supplier.setSupplierDesc("Fashionable Clothes");
		
		assertTrue("Problem in adding the supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
		
		assertTrue("Problem in deleting Supplier",supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		supplier.setSupplierDesc("Western Wear");
		
		assertTrue("Problem in updating Supplier",supplierDAO.updateSupplier(supplier));
	}
	

   @Ignore 
   @Test
    public void listCategoriesTest()
    {
    	
    	List<Supplier> listSuppliers=supplierDAO.listSuppliers();
    	assertTrue("Problem in retriving categories",listSuppliers.size()>0);
    	
    	for(Supplier supplier:listSuppliers) 
    	{
    	System.out.print(supplier.getSupplierId()+"                ");
    	System.out.print(supplier.getSupplierName()+"              ");
    	}
    	

        }
}

