package com.ammfec.service;

import com.ammfec.db.UserModel;
import com.ammfec.db.UserRepository;
import com.ammfec.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        Iterable<UserModel> usersModel = repository.findAll();

        List<User> users = new ArrayList<>();
        for (UserModel userModel : usersModel) {
            User user = User.builder()
                    .id(userModel.getId())
                    .name(userModel.getName())
                    .lastName(userModel.getLastName())
                    .email(userModel.getEmail())
                    .type(userModel.getType())
                    .address(userModel.getAddress())
                    .build();

            users.add(user);
        }

        return users;
    }

    @Override
    public User getUser(Integer id) {
        Optional<UserModel> userModel = repository.findById(id);

        return userModel.map(model -> User.builder()
                .id(model.getId())
                .name(model.getName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .type(model.getType())
                .address(model.getAddress())
                .build()).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }
}
