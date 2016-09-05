package io.fruitbase.api.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


import io.fruitbase.model.dbconfig.MySqlConfig;

@Configuration
@Import({ MySqlConfig.class, ServiceBeanConfig.class })
public class AppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

}
