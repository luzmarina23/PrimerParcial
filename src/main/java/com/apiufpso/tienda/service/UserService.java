package com.apiufpso.tienda.service;

import com.apiufpso.tienda.exception.NotFoundException;
import com.apiufpso.tienda.model.User;
import com.apiufpso.tienda.repository.UserRepository;
import com.apiufpso.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User userReq){
        userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
        return userRepository.save(userReq);
    }
    public  User getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User updateUser(User userReq, Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND.getMessage());
        }
        userBd.get().setFirstName(userReq.getFirstName());
        userBd.get().setLastName(userReq.getLastName());
        //userBd.get().setAddress(userReq.getAddress());
        userBd.get().setPhone(userReq.getPhone());
        return userRepository.save(userBd.get());
    }
    public boolean deleteUser(Long id){
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND.getMessage());
        }
        userRepository.delete(userBd.get());
        return true;
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
}
