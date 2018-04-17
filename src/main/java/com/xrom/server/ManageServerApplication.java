package com.xrom.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xrom.server.mapper")
public class ManageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageServerApplication.class, args);
	}
}
