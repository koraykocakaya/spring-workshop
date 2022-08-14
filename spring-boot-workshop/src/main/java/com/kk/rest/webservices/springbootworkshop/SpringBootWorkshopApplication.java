package com.kk.rest.webservices.springbootworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Spring Boot uygulamasi bu mainin calistirilmasi ile baslayacaktir
 * 2. Standart 8080 portu ve Tomcat (bu versiyonda 9) ile baslayacaktir, 
 *  application.properties dosyasinda server.port=8093 vs ile degistirilebilmektedir
 * 3. Burada Rest icin yazdigimiz Controller bu class ile ayni package veya subpackageinda olmasi gerekmektedir (HelloWorldController gibi)
 * @author korayk
 */
@SpringBootApplication
public class SpringBootWorkshopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWorkshopApplication.class, args);
	}

}
