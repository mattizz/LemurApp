package pl.parklinowy.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parklinowy.server.entity.User;
import pl.parklinowy.server.exception.UserNotFoundException;
import pl.parklinowy.server.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> showAllUser() {
        List<User> userList = this.userRepository.findAll();

        if (userList.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            return userList;
        }
    }

    public List<User> showActiveUser() {
        List<User> userList = this.userRepository.findAll().stream().filter(user -> user.isActive()).collect(Collectors.toList());

        if (userList.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            return userList;
        }
    }

    public User createUser(final User user) {
        user.setStartDate(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    public void deactivateUser(final Integer id) {

        Optional<User> userToDeactivate = this.userRepository.findAll().stream().filter(t -> t.getUserId() == id && t.isActive()).findFirst();

        if (userToDeactivate.isPresent()) {
            User user = this.userRepository.findAll().stream().filter(t -> t.getUserId() == id).findFirst().get();
            user.setFinishDate(LocalDateTime.now());
            user.setActive(false);
            this.userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public void activateUser(final Integer id) {

        Optional<User> userToDeactivate = this.userRepository.findAll().stream().filter(t -> t.getUserId()==id && t.isActive()).findFirst();

        if (userToDeactivate.isPresent()) {
            User user = this.userRepository.findAll().stream().filter(t -> t.getUserId() == id).findFirst().get();
            user.setActive(true);
            this.userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public User updateUser(final Integer id, User user) {

        Optional<User> userUpdate = this.userRepository.findAll().stream().filter(t -> t.getUserId() == id && t.isActive()).findFirst();

        if (userUpdate.isPresent()) {
            User userToEdit = this.userRepository.findAll().stream().filter(t -> t.getUserId() == id && t.isActive()).findFirst().get();
            userToEdit.setFirstName(user.getFirstName());
            userToEdit.setLastName(user.getLastName());
            userToEdit.setIdentityCardNumber(user.getIdentityCardNumber());
            userToEdit.setAdditionalText(user.getAdditionalText());
            userToEdit.setPay(user.isPay());
            userToEdit.setRun(user.getRun());
            userToEdit.setActive(user.isActive());
            return this.userRepository.save(userToEdit);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
