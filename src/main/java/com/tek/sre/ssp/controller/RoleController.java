package com.tek.sre.ssp.controller;

import com.tek.sre.ssp.entity.Role;
import com.tek.sre.ssp.entity.RoleRequest;
import com.tek.sre.ssp.entity.User;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import com.tek.sre.ssp.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@ControllerAdvice
@Api(tags = "Roles")
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //Create Role
    @PostMapping("/role")
    @ApiOperation(value = "This method is used to create a new role.")
    public ResponseEntity<? extends Object> createRole(@Valid @RequestBody RoleRequest roleRequest) {
//        return this.roleService.createRole(role);
        try {
            Role createdRole = roleService.createRole(roleRequest);
            return ResponseEntity.ok(createdRole);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Get all the roles
    @GetMapping("/roles")
    @ApiOperation(value = "This method is used to get all the roles.")
    public List<Role> getAllRoles() {
        return this.roleService.getAllRoles();
    }

    //Get role by id
    @GetMapping("/role/{id}")
    @ApiOperation(value = "This method is used to get the role details of specific id.")
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Integer roleId)
            throws ResourceNotFoundException {
        Role role = roleService.getRoleById(roleId);
        return ResponseEntity.ok().body(role);
    }

    //Update role by id
    @PutMapping("updateRole/{id}")
    @ApiOperation(value = "This method is used to update role details for a specific id")
    public ResponseEntity updateRole(@PathVariable(value = "id") Integer roleId, @Valid @RequestBody Role roleDetails) throws ResourceNotFoundException {
        Role updatedRole = roleService.updateRole(roleId, roleDetails);
        return ResponseEntity.ok(updatedRole);
    }


}
