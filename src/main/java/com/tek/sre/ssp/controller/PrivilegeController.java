package com.tek.sre.ssp.controller;

import com.tek.sre.ssp.entity.Privilege;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import com.tek.sre.ssp.service.PrivilegeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Privileges")
@RequestMapping("/api/v1")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping("/privilege")
    public Privilege createPrivilege(@RequestBody Privilege privilege) {
        return this.privilegeService.createPrivilege(privilege);
    }

    @GetMapping("/privileges")
    public List<Privilege> getAllPrivilege() {
        return this.privilegeService.getAllPrivilege();
    }

    @GetMapping("/privilege/{id}")
    public ResponseEntity<Privilege> getPrivilegeById(@PathVariable(value = "id") Integer privilegeId)
            throws ResourceNotFoundException {
        Privilege privilege = privilegeService.getPrivilegeById(privilegeId);
        return ResponseEntity.ok().body(privilege);
    }

    @PutMapping("updatePrivilege/{id}")
    public ResponseEntity updatePrivilege(@PathVariable(value = "id") Integer privilegeId, @Valid @RequestBody Privilege privilegeDetails) throws ResourceNotFoundException {
        Privilege updatedPrivilege = privilegeService.updatePrivilege(privilegeId, privilegeDetails);
        return ResponseEntity.ok(updatedPrivilege);
    }

}
