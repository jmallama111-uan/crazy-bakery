package com.uan.edu.crazy_bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
public class CrazyBakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyBakeryApplication.class, args);
	}

}
