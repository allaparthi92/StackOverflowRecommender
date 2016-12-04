package edu.asu.dv.spring.configuration;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * This is the default class that will load all the spring related
 * configurations.
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "edu.asu.dv.*" })
public class ApplicationConfig {

	@Bean(name = "categoryTagProperties")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("mapping/CategoryTagMapping.properties"));
		return bean;
	}

	@Bean(name = "userNameProperties")
	public PropertiesFactoryBean userMapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("mapping/userNames.properties"));
		return bean;
	}

	@Bean(name = "recommededProperties")
	public PropertiesFactoryBean CourseMapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("mapping/recommendedCourses.properties"));
		return bean;
	}

}
