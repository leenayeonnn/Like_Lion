package org.example.iocexam.iocexam;

import org.example.iocexam.iocexam.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocExamApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(IocExamApplication.class, args);

		UserController userController = context.getBean(UserController.class);
		userController.joinUser();
	}

}
