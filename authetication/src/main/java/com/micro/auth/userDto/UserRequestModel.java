package com.micro.auth.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestModel {
    private String userName;
    private String password;
    private String emailId;
    private long mobileNumber;
    private boolean isConfirmed;
    private String userType;
}
