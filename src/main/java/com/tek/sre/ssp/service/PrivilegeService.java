package com.tek.sre.ssp.service;

import com.tek.sre.ssp.dao.PrivilegeDao;
import com.tek.sre.ssp.entity.Privilege;
import com.tek.sre.ssp.entity.Role;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;

    public Privilege createPrivilege(@NotNull Privilege privilege) {
        privilege.setCreatedAt(LocalDateTime.now());
        privilege.setUpdatedAt(LocalDateTime.now());
        return privilegeDao.save(privilege);
    }

    public List<Privilege> getAllPrivilege() {
        return (List<Privilege>) this.privilegeDao.findAll();
    }

    public Privilege getPrivilegeById(Integer privilegeId) throws ResourceNotFoundException {
        return privilegeDao.findById(privilegeId)
                .orElseThrow(() -> new ResourceNotFoundException("Privilege not found for this id: " + privilegeId));
    }

    public Privilege updatePrivilege(Integer privilegeId, Privilege privilegeDetails) throws ResourceNotFoundException {
        Privilege privilege = privilegeDao.findById(privilegeId)
                .orElseThrow(() -> new ResourceNotFoundException("Privilege not found for this id :" + privilegeId));
        privilege.setPrivilegeName(privilegeDetails.getPrivilegeName());
        privilege.setUpdatedAt(LocalDateTime.now());
        return privilegeDao.save(privilege);
    }

}
