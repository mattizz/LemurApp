package pl.parklinowy.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.parklinowy.server.entity.User;
import pl.parklinowy.server.exception.UserNotFoundException;
import pl.parklinowy.server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<User>> showAllUsers() {
        try {
            return new ResponseEntity<>(this.userService.showAllUser(), HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<User>> showActiveUsers() {
        try {
            return new ResponseEntity<>(this.userService.showActiveUser(), HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> addNewUser(@RequestBody final User user) {
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity deactivateUser(@PathVariable final Integer id, @RequestBody final User user) {
        try {
            this.userService.deactivateUser(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/all/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity activateUser(@PathVariable final Integer id,@RequestBody final User user) {
        try {
            this.userService.activateUser(id, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/all/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> updateUser(@PathVariable final Integer id, @RequestBody final User user) {
        try {
            return new ResponseEntity<>(this.userService.updateUser(id, user), HttpStatus.OK);
        } catch (UserNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
