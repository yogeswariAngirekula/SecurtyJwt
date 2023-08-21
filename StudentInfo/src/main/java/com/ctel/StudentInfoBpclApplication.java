package com.ctel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = com.yogi")
public class StudentInfoBpclApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoBpclApplication.class, args);
		System.out.println(".>>>..run succssfully....>>>>>>");
	}

}
