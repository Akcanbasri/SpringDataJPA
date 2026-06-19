package com.basri.SpringDataJPA;

import com.basri.SpringDataJPA.config.GlobalPropertiesSecond;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:app.properties")
public class Starter {

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

}
