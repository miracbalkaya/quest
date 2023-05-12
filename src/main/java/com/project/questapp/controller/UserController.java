package com.project.questapp.controller;

import com.project.questapp.entities.User;
import com.project.questapp.repository.UserRepository;
import com.project.questapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

   @GetMapping()
    public List<User> getAllUsers(){
       return userService.getAllUsers();
   }

   @PostMapping
    public User createUser(@RequestBody User newUser){
       return userService.saveOneUser(newUser);
   }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
       return userService.getOneUserById(userId);
   }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }


    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
       this.userService.deleteById(userId);
   }
}
