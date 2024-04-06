package jaca.stelius.ecommerce.controller;

import jaca.stelius.ecommerce.model.Users;
import jaca.stelius.ecommerce.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") Long userId) {
        return usersService.getUsersById(userId);
    }

    @PostMapping("")
    public Users createUsers(@RequestBody Users users){
        return usersService.createUser(users);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable("id") Long userId, @RequestBody Users updatedUsers) {
        return usersService.updateUser(userId, updatedUsers);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        usersService.deleteUsers(userId);
    }

}
