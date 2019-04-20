package com.eshop.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.dao.CartDAO;
import com.eshop.model.CartItem;


public class CartDAOTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    context.scan("com.eshop");
	    context.refresh();
	    
	    cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	
	@Test
	public void addCartItemtest() 
	{
		CartItem cartItem=new CartItem();
		cartItem.setProId(417);
		cartItem.setProName("Brown Bag");
		cartItem.setQuantity(2);
		cartItem.setProprice(2000);
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername("Lucky");
		
		assertTrue("problem in adding Item into Cart",cartDAO.addCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void listAllCartItems()
	{
		
		List<CartItem> listCartItems=cartDAO.listCartItems("Lucky");
		
		assertTrue("Problem in listing the CartItems",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProId()+"\t");
			System.out.print(cartItem.getProName()+"\t");
			System.out.print(cartItem.getProprice()+"\t");
			System.out.print(cartItem.getQuantity()+"\t");
			
		}
		
	}
	
	@Ignore
	@Test
	public void updateCartItemTest()
	{
		CartItem cartItem=cartDAO.getCartItem(449);
		cartItem.setQuantity(5);
		assertTrue("Problem occured while updating cartItem",cartDAO.updateCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		CartItem cartItem=cartDAO.getCartItem(449);
		
		assertTrue("Problem occured while deleting cartItem",cartDAO.deleteCartItem(cartItem));
	}



}


