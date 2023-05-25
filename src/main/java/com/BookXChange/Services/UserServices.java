package com.BookXChange.Services;

import com.BookXChange.Model.RegistrationForm;
import com.BookXChange.Model.UserModel;
import com.BookXChange.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    @Autowired
    public UserServices(PasswordEncoder encoder, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }
    private String currentUser;

    public void saveUser(RegistrationForm form){
        userRepository.save(form.toUser(passwordEncoder));
    }

    public List<UserModel> listAllUser(){
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public UserModel getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
