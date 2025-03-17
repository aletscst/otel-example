package com.ammfec.service;

import com.ammfec.db.model.UserModel;
import com.ammfec.db.repository.UserRepository;
import com.ammfec.dto.general.User;
import com.ammfec.dto.request.UserRequest;
import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import com.ammfec.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public UsersResponse getUsers() {
        Iterable<UserModel> usersModel = repository.findAll();

        UsersResponse response = new UsersResponse();

        List<User> users = new ArrayList<>();
        for (UserModel userModel : usersModel) {
            User user = new User();
            user.setId(userModel.getId());
            user.setName(userModel.getName());
            user.setLastName(userModel.getLastName());
            user.setEmail(userModel.getEmail());
            user.setType(userModel.getType());
            user.setAddress(userModel.getAddress());

            users.add(user);
        }

        response.setUsers(users);

        return response;
    }

    @Override
    public UserResponse getUser(Integer id) {
        UserModel userModel = repository.findById(id).orElseThrow(() -> {
            log.error("User not found: {}", id);
            return new NotFoundException("User " + id + " not found");
        });

        UserResponse response = new UserResponse();
        response.setId(userModel.getId());

        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setType(userModel.getType());
        user.setAddress(userModel.getAddress());

        response.setUser(user);

        return response;
    }

    @Override
    public UserResponse createUser(UserRequest user) {
        return null;
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest user) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

}
