package com.tek.sre.ssp.dao;

import com.tek.sre.ssp.entity.Privilege;
import com.tek.sre.ssp.entity.Role;
import com.tek.sre.ssp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeDao extends JpaRepository<Privilege, Integer> {
    List<Privilege> findByIdIn(List<Integer> privilegeIds);

}
