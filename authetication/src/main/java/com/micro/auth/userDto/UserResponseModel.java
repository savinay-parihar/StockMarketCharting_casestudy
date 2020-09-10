package com.micro.auth.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {
    private String userName;
    private String emailId;
    private long mobileNumber;
    private boolean isConfirmed;
    private String userType;
}
