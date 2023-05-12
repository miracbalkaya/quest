package com.project.questapp.service;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public ResponseEntity<User> updateOneUser(Long userId, User newUser) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
