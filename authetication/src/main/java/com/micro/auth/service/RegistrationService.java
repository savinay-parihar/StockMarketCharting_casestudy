package com.micro.auth.service;

import com.micro.auth.model.User;
import com.micro.auth.userDto.UserRequestModel;
import com.micro.auth.userDto.UserResponseModel;

import java.util.List;

public interface RegistrationService {
    public UserResponseModel saveUser(UserRequestModel userRequestModel);
    public UserResponseModel fetchUserByEmailIdAndPassword(String userEmailId, String password) throws Exception;
    public UserResponseModel fetchByUserName(String userName);
    public List<UserResponseModel> getAllUsers();
    public UserResponseModel fetchUserByEmailId(String emailId) throws Exception;
}
