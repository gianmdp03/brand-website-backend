package com.gianmdp03.brand_website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@SpringBootApplication
public class BrandWebsiteApplication {

	static void main(String[] args) {
		SpringApplication.run(BrandWebsiteApplication.class, args);
	}

}
