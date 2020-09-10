package com.micro.auth.repository;

import com.micro.auth.userDto.UserRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.auth.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<User, Integer> {

    public User findByUserName(String userName);

    public User findByEmailIdAndPassword(String userEmailId, String password);

//    public UserRequestModel fetchUserByEmailId(String emailId);
    public User findByEmailId(String emailId);

}
