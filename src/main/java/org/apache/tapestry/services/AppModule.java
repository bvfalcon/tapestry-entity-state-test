package org.apache.tapestry.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.ImportModule;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.jpa.modules.JpaModule;
import org.apache.tapestry5.modules.Bootstrap4Module;

@ImportModule({ Bootstrap4Module.class, JpaModule.class })
public class AppModule
{
	public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration)
	{
		configuration.override(SymbolConstants.PRODUCTION_MODE, false);
	}
	
	public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration)
	{
		configuration.add(SymbolConstants.ENABLE_PAGELOADING_MASK, Boolean.FALSE);
		configuration.add(SymbolConstants.ENABLE_HTML5_SUPPORT, Boolean.FALSE);
	}
	
	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void setupEnvironment(MappedConfiguration<String, Object> configuration)
	{
		configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
	}
}
