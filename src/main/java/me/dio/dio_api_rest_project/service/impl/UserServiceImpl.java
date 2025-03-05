package me.dio.dio_api_rest_project.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.dio_api_rest_project.model.User;
import me.dio.dio_api_rest_project.repository.UserRepository;
import me.dio.dio_api_rest_project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account ID already exists.");
        }
        return userRepository.save(userToCreate);
    }

    

}
