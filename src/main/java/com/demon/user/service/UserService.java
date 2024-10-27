package com.demon.user.service;

import com.demon.user.model.UserModel;
import com.demon.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getAllUserModels(){
        return (List<UserModel>)userRepository.findAll();
    }

    public UserModel createUserModel(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel getUserModelById( long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel not exist with id:" + id));
    }

    public UserModel updateUserModel( long id, UserModel UserModelDetails) {
        UserModel updateUserModel = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel not exist with id: " + id));

        updateUserModel.setFirstName(UserModelDetails.getFirstName());
        updateUserModel.setLastName(UserModelDetails.getLastName());
        updateUserModel.setEmailId(UserModelDetails.getEmailId());

        return userRepository.save(updateUserModel);
    }

    public void deleteUserModel(long id){
        UserModel userModel = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserModel not exist with id: " + id));

        userRepository.delete(userModel);

    }
}
