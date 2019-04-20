package com.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshop.dao.CartDAO;
import com.eshop.dao.OrderDetailDAO;
import com.eshop.dao.ProductDAO;
import com.eshop.dao.UserDetailDAO;
import com.eshop.model.CartItem;
import com.eshop.model.OrderDetail;
import com.eshop.model.UserDetail;


@Controller
public class PaymentController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@RequestMapping("/checkout")
	public String checkout(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList",cartItemList);
		m.addAttribute("totalAmount",this.getTotalAmount(cartItemList));
		
		String address=userDetailDAO.getUser(username.trim()).getCustomerAddr();
		m.addAttribute("addr",address);
		
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr")String addr,Model m,HttpSession session)
	
	{
		String username=(String)session.getAttribute("username");
		List<CartItem> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList",cartItemList);
		m.addAttribute("totalAmount",this.getTotalAmount(cartItemList));
		
		UserDetail userDetail=userDetailDAO.getUser(username);
		userDetail.setCustomerAddr(addr);
		userDetailDAO.updateAddress(userDetail);	
		
		String address=userDetail.getCustomerAddr();
		m.addAttribute("addr",address);
		return "OrderConfirm";
	}
	
	@RequestMapping(value="/payment")
	public String paymentPage(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		return "Payment";
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("pmode")String pmode,Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setShippingAddr(userDetailDAO.getUser(username).getCustomerAddr());
		orderDetail.setTranType(pmode);
		orderDetail.setUsername(username);
		
        List<CartItem> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList",cartItemList);
		m.addAttribute("totalAmount",this.getTotalAmount(cartItemList));
		
		UserDetail userInfo=userDetailDAO.getUser(username);
		
		orderDetail.setFinalAmount(this.getTotalAmount(cartDAO.listCartItems(username)));
		
		orderDetailDAO.saveOrder(orderDetail);
		orderDetailDAO.updateCart(username);
		
		m.addAttribute("orderDetail",orderDetail);
		
		
		return "Receipt";
	}
	public int getTotalAmount(List<CartItem> cartList)
	{
		int totalAmount=0,count=0;
		
		while(count<cartList.size())
		{
		  totalAmount=totalAmount+(cartList.get(count).getQuantity()*cartList.get(count).getProprice());
	      count++;		
		}
		return totalAmount;
	}
}
