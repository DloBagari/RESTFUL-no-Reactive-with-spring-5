package org.springrest.simplerestAppnoReactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//define this class to scan all other classes in its package
@ComponentScan //(org.springrest)
public class SimpleRestAppNoReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestAppNoReactiveApplication.class, args);
	}
}
