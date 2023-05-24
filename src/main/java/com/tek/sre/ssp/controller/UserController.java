package com.tek.sre.ssp.controller;

import com.tek.sre.ssp.entity.UserRequest;
import com.tek.sre.ssp.exception.ResourceNotFoundException;
import com.tek.sre.ssp.service.UserService;
import com.tek.sre.ssp.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController(value = "/users")
@Api(tags = "Users")
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    //Create a User
    @PostMapping("/user")
    @ApiOperation(value = "This method is used to create a new user.")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest) {
        try {
            User createdUser = userService.createUser(userRequest);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    //Get all the users
    @ApiOperation(value = "This method is used to get all the users.")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "This method is used to get the user details of specific id.")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userId)
            throws ResourceNotFoundException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("updateUser/{id}")
    @ApiOperation(value = "This method is used to update user details for a specific id")
    public ResponseEntity updateUser(@PathVariable(value = "id") Integer userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User updatedUser = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }


}
