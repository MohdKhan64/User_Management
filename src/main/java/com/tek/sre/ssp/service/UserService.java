package com.tek.sre.ssp.service;

import com.tek.sre.ssp.dao.RoleDao;
import com.tek.sre.ssp.dao.UserDao;
import com.tek.sre.ssp.entity.Role;
import com.tek.sre.ssp.entity.User;

import com.tek.sre.ssp.entity.UserRequest;
import com.tek.sre.ssp.exception.BadRequestException;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import com.tek.sre.ssp.util.PasswordUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;


    public User createUser(UserRequest userRequest) {
        List<Role> roles = roleDao.findByIdIn(userRequest.getRoleIds());
        if (roles.isEmpty()) {
            throw new BadRequestException("At least one role must be provided");
        }
        User user = userRequest.getUser();
        user.setPassword(PasswordUtil.getHashValue(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setRoles(roles);
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) this.userDao.findAll();
    }

    public User getUserById(Integer userId) throws ResourceNotFoundException {
        return userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id: " + userId));
    }

    public User updateUser(Integer userId, User userDetails) throws ResourceNotFoundException {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :" + userId));
        user.setUserEmailId(userDetails.getUserEmailId());
        user.setRoles(userDetails.getRoles());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setPassword(PasswordUtil.getHashValue(user.getPassword()));
        user.setUpdatedAt(LocalDateTime.now());

        return userDao.save(user);
    }

}
