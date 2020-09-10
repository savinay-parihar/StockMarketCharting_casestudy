package com.micro.auth.controller;


import com.micro.auth.service.RegistrationService;
import com.micro.auth.userDto.UserRequestModel;
import com.micro.auth.userDto.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.micro.auth.model.User;
import com.micro.auth.service.RegistrationServiceImpl;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }


    @PostMapping("/registration")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserResponseModel> registerUser(@RequestBody UserRequestModel userRequestModel) throws Exception {
//        String tempEmailId = userRequestModel.getEmailId();
//        if (tempEmailId != null && !"".equals(tempEmailId)) {
//            UserResponseModel userObj = service.fetchUserByEmailId(tempEmailId);
//            if (userObj != null) {
//                throw new Exception("User with " + tempEmailId + "already exist");
//            }
//        }
        return new ResponseEntity<>(service.saveUser(userRequestModel),HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseModel>> getAllUsers()
    {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public UserResponseModel loginUser(@RequestBody UserRequestModel user) throws Exception {
        String userEmailId = user.getEmailId();
        String password = user.getPassword();
        UserResponseModel userObj = null;

        if (userEmailId != null && password != null) {
            userObj = service.fetchUserByEmailIdAndPassword(userEmailId, password);

        }
        if (userObj == null) {
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }

}
