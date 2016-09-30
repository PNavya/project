package com.niit.ShoppingCart.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Category;

@EnableTransactionManagement
@Repository(value="categoryDAO")

public   class CategoryDAOImpl implements CategoryDAO {
	

	@Autowired
	private SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;

	}

	@Transactional
	public boolean save(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Transactional
	public Category get(String catid) {
		// TODO Auto-generated method stub
		/*Session s=sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();*/
		String hql = "from Category where catid=" + "'" + catid + "'";
		System.out.println(hql);
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		System.out.println("test case");
		if (list == null)

			return null;
		else {
			System.out.println("Test case 4");
			return list.get(0);
		}
	
	}

	@Transactional
	public List<Category> list() {
		// TODO Auto-generated method stub
		/*Session s=sessionFactory.getCurrentSession();
		Transaction tx=s.beginTransaction();*/
		String hql = "from Category";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();

	
	}

	@Transactional
	public Category getId(String catid) {
		// TODO Auto-generated method stub
		
		String hql = "from Category where catid=" + "'" + catid + "'";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
		
   

	}
}



