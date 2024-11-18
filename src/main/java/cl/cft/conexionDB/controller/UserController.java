package cl.cft.conexionDB.controller;

import cl.cft.conexionDB.entities.Users;
import cl.cft.conexionDB.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Optional<Users> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        if (!userService.existUser(user.getId())) {
            Users newUser = userService.saveUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Users> putUser(@RequestBody Users user) {
        if (userService.existUser(user.getId())) {
            Users newUser = userService.saveUser(user);
            return ResponseEntity.ok(userService.saveUser(user));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
