package edu.eci.arep.Lab05.controller;

import edu.eci.arep.Lab05.model.Property;
import edu.eci.arep.Lab05.model.User;
import edu.eci.arep.Lab05.repository.UserRepository;
import edu.eci.arep.Lab05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Property>> getUserProperties(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getPropertyById(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user)) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update( @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user)) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        User usr = userService.findUserById(id);
        userService.deleteUserById(id);
        return ResponseEntity.ok("se elimino correctamente el usuario "+usr.getUsername());
    }

}
