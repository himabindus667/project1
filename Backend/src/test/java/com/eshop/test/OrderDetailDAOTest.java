package com.eshop.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eshop.dao.OrderDetailDAO;
import com.eshop.model.OrderDetail;


public class OrderDetailDAOTest 
{
    static OrderDetailDAO orderDetailDAO;
    
    @BeforeClass    
    public static void executeFirst()
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.eshop");
	    context.refresh();
	    
	    orderDetailDAO=(OrderDetailDAO) context.getBean("orderDetailDAO");
    }
   
   @Ignore
	@Test
	public void saveOrdertest() 
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(101);
		orderDetail.setShippingAddr("Mumbai");
		orderDetail.setFinalAmount(2000);
		orderDetail.setTranType("COD");
		orderDetail.setUsername("Lucky");
		
		assertTrue("Problem in saving order",orderDetailDAO.saveOrder(orderDetail));
	}
    @Ignore
	@Test
	public void updateCartTest()
	{
		assertTrue("Problem in updating Cart",orderDetailDAO.updateCart("Lucky"));
		
	}

}
