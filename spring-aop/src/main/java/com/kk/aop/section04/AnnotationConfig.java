package com.kk.aop.section04;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.kk.aop.section04")
@EnableAspectJAutoProxy
public class AnnotationConfig {

}
