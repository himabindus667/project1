package com.eshop.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.UserDetailDAO;
import com.eshop.model.UserDetail;



@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO 
{
    @Autowired
    SessionFactory sessionFactory;
    
	public boolean registerUser(UserDetail user) 
    {
    	try
        {
        sessionFactory.getCurrentSession().save(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
}

	public boolean updateAddress(UserDetail user) {
		try
        {
        sessionFactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
}

	public UserDetail getUser(String username) {
		{
		    Session session=sessionFactory.openSession();
	        UserDetail user=session.get(UserDetail.class,username); 
	        session.close();
			return user;
	}
}

	@Override
	public boolean UpdateUser(UserDetail user) {
	
		try
        {
        sessionFactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
}
}