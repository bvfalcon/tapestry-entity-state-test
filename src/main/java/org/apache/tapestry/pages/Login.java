package org.apache.tapestry.pages;

import javax.persistence.EntityManager;

import org.apache.tapestry.entities.User;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;

public class Login
{
	@Property
	private String username;
	
	@Property
	private String password;
	
	@Inject
	private EntityManager entityManager;
	
	@Inject
	private ApplicationStateManager applicationStateManager;
	
	Object onSuccessFromLogin()
	{
		entityManager.getTransaction().begin();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		applicationStateManager.set(User.class, user);
		return Index.class;
	}
}
