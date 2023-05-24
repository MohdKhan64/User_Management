package com.tek.sre.ssp.dao;

import com.tek.sre.ssp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    //   List<Role> findRoleByUserId(Integer userId);
    List<Role> findByIdIn(List<Integer> ids);

}
