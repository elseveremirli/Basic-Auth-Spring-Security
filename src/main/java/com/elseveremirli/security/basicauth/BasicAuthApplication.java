package com.elseveremirli.security.basicauth;

import com.elseveremirli.security.basicauth.dto.CreateUserRequest;
import com.elseveremirli.security.basicauth.model.Role;
import com.elseveremirli.security.basicauth.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

    private final UserService userService;
    public BasicAuthApplication(UserService userService){
        this.userService=userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData(){
        CreateUserRequest request = CreateUserRequest.builder()
                .name("Elsever")
                .username("elseveremirli")
                .password("pass")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();
        userService.createUser(request);
        CreateUserRequest request2 = CreateUserRequest.builder()
                .name("Sexavet")
                .username("sexavetemirli")
                .password("pass")
                .authorities(Set.of(Role.ROLE_MOD))
                .build();
        userService.createUser(request2);
        CreateUserRequest request3 = CreateUserRequest.builder()
                .name("Elvin")
                .username("elvineynullayev")
                .password("pass")
                .authorities(Set.of(Role.ROLE_USER))
                .build();
        userService.createUser(request3);
    }
}
