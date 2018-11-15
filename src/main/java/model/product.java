package model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class product {
	@Autowired
	private SessionFactory sessionFactory;
}
