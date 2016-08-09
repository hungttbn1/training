package io.fruitbase.api.config;

import io.fruitbase.api.common.ApiConst;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { ApiConst.BUSINESS_BEAN_PACKAGE })
public class ServiceBeanConfig {

}
