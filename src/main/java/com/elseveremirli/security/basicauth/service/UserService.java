package com.elseveremirli.security.basicauth.service;

import com.elseveremirli.security.basicauth.dto.CreateUserRequest;
import com.elseveremirli.security.basicauth.model.User;
import com.elseveremirli.security.basicauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest request){
        User newUser = User.builder()
                .name(request.name())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .accountNonLocked(true)
                .accountNonExpired(true)
                .build();
        return userRepository.save(newUser);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

}
