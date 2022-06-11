package com.kk.section09;
	
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 1. @ComponentScan bean icin hangi packagelarin taranacagini belirtmektedir
 * 2. Bu packagelerda @Component veya @Service ile isaretlenenler bean olarak contexte yuklenecektir
 * @author korayk
 */
@Configuration
@ComponentScan(basePackages = "com.kk.section09.bean")
@PropertySource("app.properties")
public class ApplicationHelperConfig {

}
