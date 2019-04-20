package com.eshop.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.CategoryDAO;
import com.eshop.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    SessionFactory sessionFactory;
    
	public boolean addCategory(Category category) {
        try
        {
      sessionFactory.getCurrentSession().saveOrUpdate(category);

     

        return true;
        }
        catch(Exception e)
        {
    		System.out.println(e);

        return false;
	}
}
	public boolean deleteCategory(Category category) {
		try
        {
        sessionFactory.getCurrentSession().delete(category);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}
	public boolean updateCategory(Category category) {
		try
        {
        sessionFactory.getCurrentSession().update(category);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
}
	public List<Category> listCategories() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Category");
        List<Category> listCategories=query.list();
        session.close();
		return listCategories;
	}
	public Category getCategory(int categoryID) {
        Session session=sessionFactory.openSession();
        Category category=session.get(Category.class,categoryID);        
		return category ;
	}
	

}
