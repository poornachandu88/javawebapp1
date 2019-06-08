package com.poorna.javaweb;

import java.util.concurrent.TimeUnit;


import org.springframework.context.MessageSource;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.poorna.javaweb.controller"})
public class SpringWebConfig extends WebMvcConfigurerAdapter{

	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/jsp/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setMaxUploadSize(104857600);   // 20MB  20971520   //100mb
	   /* commonsMultipartResolver.setMaxInMemorySize(1048576); */ // 1MB
	    return commonsMultipartResolver;
	}
		
	@Bean
	   public MessageSource messageSource() {
	      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	      source.setBasenames(new String[] {"validation"});
	      return source;
	   }

	   @Override
	   public Validator getValidator() {
	      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	      validator.setValidationMessageSource(messageSource());
	      return validator;
	   }
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for CSS and JS
	      registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	      
	   // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

	   }   



}