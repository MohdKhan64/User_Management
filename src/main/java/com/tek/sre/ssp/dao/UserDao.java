package com.tek.sre.ssp.dao;

import com.tek.sre.ssp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserEmailId(String userEmailId);

    //List<User> findUserByRoleId(Integer roleId);
}