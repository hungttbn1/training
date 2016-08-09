package io.fruitbase.api.config;

import io.fruitbase.model.dbconfig.MySqlConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@Import({ MySqlConfig.class, ServiceBeanConfig.class })
public class AppConfig extends AbstractSecurityWebApplicationInitializer {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
