package com.janzenzhang.springboot.blog.service;

import com.janzenzhang.springboot.blog.domain.User;
import com.janzenzhang.springboot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {

        userRepository.delete(id);

    }


    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }


    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {

        name = "%" + name + "%";
        Page<User> users = userRepository.findByNameLike(name, pageable);
        return users;

    }
}