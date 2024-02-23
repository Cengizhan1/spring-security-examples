package com.cengizhanyavuz.security.basicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cengizhanyavuz.security.basicauth.dto.CreateUserRequest;
import com.cengizhanyavuz.security.basicauth.model.Role;
import com.cengizhanyavuz.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Cengizhan")
				.username("cengizhan")
				.password("123456")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("Admin")
				.username("admin")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request3);
	}
}