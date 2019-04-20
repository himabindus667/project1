package com.eshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.dao.CategoryDAO;
import com.eshop.model.Category;


public class CategoryDAOTest {

@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.eshop");
	    context.refresh();

	    
	    categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Men Dresses");
		category.setCategoryDesc("Casual");
		
		assertTrue("Problem in adding the category",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(65);
		
		assertTrue("Problem in deleting category",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(66);
		category.setCategoryDesc("Western Wear");
		
		assertTrue("Problem in updating category",categoryDAO.updateCategory(category));
	}
	
	 
	   @Test
	    public void listCategoriesTest()
	    {
	    	
	    	List<Category> listCategories=categoryDAO.listCategories();
	    	assertTrue("Problem in retriving categories",listCategories.size()>0);
	    	
	    	for(Category category:listCategories) 
	    	{
	    	System.out.print(category.getCategoryID()+"                ");
	    	System.out.print(category.getCategoryName()+"              ");
	    	System.out.println(category.getCategoryDesc()+"            ");

	        }
	    }
}


