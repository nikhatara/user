package com.demon.user.controller;

import com.demon.user.model.UserModel;
import com.demon.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Get All Users
     * @return
     */
    @GetMapping
    public List<UserModel> getAllUserModels(){
        return userService.getAllUserModels();
    }

    /**
     * Create One User
     * @param UserModel
     * @return
     */
    @PostMapping
    public UserModel createUserModel(@RequestBody UserModel UserModel) {
        return userService.createUserModel(UserModel);
    }

    /**
     * Get User By Id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<UserModel> getUserModelById(@PathVariable  long id){
        return ResponseEntity.ok(userService.getUserModelById(id));
    }

    /**
     * Update user by id
     * @param id
     * @param userModelDetails
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<UserModel> updateUserModel(@PathVariable long id,@RequestBody UserModel userModelDetails) {
        return ResponseEntity.ok(userService.updateUserModel(id,userModelDetails));
    }

    /**
     * Delete user by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUserModel(@PathVariable long id){

        userService.deleteUserModel(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

