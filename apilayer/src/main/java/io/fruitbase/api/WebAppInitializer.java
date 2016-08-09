package io.fruitbase.api;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import io.fruitbase.api.config.AppConfig;
import io.fruitbase.api.config.MVCConfig;

public class WebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MVCConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
