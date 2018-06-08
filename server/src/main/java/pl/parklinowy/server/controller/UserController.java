package pl.parklinowy.server.controller;

import pl.parklinowy.server.entity.User;
import pl.parklinowy.server.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<User>> showUsers(){
        try{
            return new ResponseEntity<>(this.userService.showAllUser(), HttpStatus.OK);
        }catch (UserNotFoundException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> addNewUser(@RequestBody final User user){
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public void deactivateUser(@PathVariable("id") final String id){
        this.userService.deactivateUser(id);
    }

    @PutMapping("/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> editUser(@PathVariable final int id, @RequestBody final User user) {
        try{
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
