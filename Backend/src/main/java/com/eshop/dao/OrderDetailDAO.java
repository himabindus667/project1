package com.eshop.dao;

import java.util.List;

import com.eshop.model.OrderDetail;




public interface OrderDetailDAO
{
	public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);
    
}
