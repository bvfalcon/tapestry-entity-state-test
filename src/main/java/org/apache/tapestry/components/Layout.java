package org.apache.tapestry.components;

import org.apache.tapestry.entities.User;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationStateManager;

public class Layout
{
	@Inject
	private ApplicationStateManager applicationStateManager;
	
	public String getUsername()
	{
		//User user = applicationStateManager.exists(User.class) ? applicationStateManager.get(User.class) : null; // this works correctly 
		User user = applicationStateManager.getIfExists(User.class); // this gives an error
		return user != null ? user.getUsername() : null;
	}
	
	public boolean isLoggedIn()
	{
		return applicationStateManager.exists(User.class);
	}
}
