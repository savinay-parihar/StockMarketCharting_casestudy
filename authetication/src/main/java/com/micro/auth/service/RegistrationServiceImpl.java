package com.micro.auth.service;

import com.micro.auth.userDto.UserRequestModel;
import com.micro.auth.userDto.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.auth.model.User;
import com.micro.auth.repository.RegistrationRepo;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private final RegistrationRepo repo;
    private final ModelMapper modelMapper;

    public RegistrationServiceImpl(RegistrationRepo repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public UserResponseModel saveUser(UserRequestModel userRequestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user=repo.save(modelMapper.map(userRequestModel,User.class));
        return modelMapper.map(user,UserResponseModel.class);
    }


    @Override
    @Transactional
    public UserResponseModel fetchUserByEmailIdAndPassword(String userEmailId, String password) throws Exception {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user=repo.findByEmailIdAndPassword(userEmailId, password);
        if(user!=null)
            return modelMapper.map(user,UserResponseModel.class);
        else
            throw new Exception("Bad Credentials");
    }

    @Override
    public UserResponseModel fetchByUserName(String userName) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = repo.findByUserName(userName);
        return modelMapper.map(user, UserResponseModel.class);
    }

    @Override
    @Transactional
    public List<UserResponseModel> getAllUsers()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<UserResponseModel>>(){}.getType();
        List<UserResponseModel> postDtoList = modelMapper.map(repo.findAll(),listType);
        return postDtoList;
    }

    @Override
    public UserResponseModel fetchUserByEmailId(String emailId) throws Exception {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = repo.findByEmailId(emailId);
        if(user !=null)
            return modelMapper.map(user, UserResponseModel.class);
        else
            throw new Exception("User with " + emailId + "already exist");

    }


}
