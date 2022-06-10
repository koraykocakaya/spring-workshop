package com.kk.section9;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.kk.section9.annotatedBean")
@PropertySource("app.properties")
public class PropertyConfig {

}
