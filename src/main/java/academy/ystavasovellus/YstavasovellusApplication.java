package academy.ystavasovellus;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.MappedSuperclass;


@SpringBootApplication
public class YstavasovellusApplication {

	public static void main(String[] args) {
		SpringApplication.run(YstavasovellusApplication.class, args);
	}


}


