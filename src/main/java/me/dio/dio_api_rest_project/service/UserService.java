package me.dio.dio_api_rest_project.service;

import me.dio.dio_api_rest_project.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    
}
