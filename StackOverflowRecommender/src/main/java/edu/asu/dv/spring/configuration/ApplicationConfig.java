package edu.asu.dv.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

}
