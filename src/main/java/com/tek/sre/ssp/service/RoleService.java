package com.tek.sre.ssp.service;

import com.tek.sre.ssp.dao.PrivilegeDao;
import com.tek.sre.ssp.dao.RoleDao;
import com.tek.sre.ssp.entity.Privilege;
import com.tek.sre.ssp.entity.Role;
import com.tek.sre.ssp.entity.RoleRequest;
import com.tek.sre.ssp.exception.BadRequestException;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PrivilegeDao privilegeDao;

    //Create Role
    public Role createRole(RoleRequest roleRequest) {
        List<Privilege> privileges = privilegeDao.findByIdIn(roleRequest.getPrivilegeIds());
        if (privileges.isEmpty()) {
            throw new BadRequestException("At least one privilege must be provided");
        }
        Role role = roleRequest.getRole();
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        role.setPrivileges(privileges);
        return roleDao.save(role);
    }

    //update role
    public List<Role> getAllRoles() {
        return (List<Role>) this.roleDao.findAll();
    }

    public Role getRoleById(Integer roleId) throws ResourceNotFoundException {
        return roleDao.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for this id: " + roleId));
    }

    public Role updateRole(Integer roleId, Role roleDetails) throws ResourceNotFoundException {
        Role role = roleDao.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :" + roleId));
        role.setRoleName(roleDetails.getRoleName());
        role.setUpdatedAt(LocalDateTime.now());
        return roleDao.save(role);
    }
}
