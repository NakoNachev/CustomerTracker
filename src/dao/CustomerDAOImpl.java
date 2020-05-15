package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//db connection of .xml file
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query <Customer> query = session.createQuery("from Customer c", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
