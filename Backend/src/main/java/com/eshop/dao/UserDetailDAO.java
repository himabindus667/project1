package com.eshop.dao;

import com.eshop.model.UserDetail;

public interface UserDetailDAO {
	public boolean registerUser(UserDetail user);
	public boolean updateAddress(UserDetail user);
	public UserDetail getUser(String username);
	public boolean UpdateUser(UserDetail user);

}
