package pl.parklinowy.server.service;

import org.joda.time.DateTime;
import pl.parklinowy.server.entity.User;
import pl.parklinowy.server.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parklinowy.server.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
        List<User> userList = this.userRepository.findAll().stream().filter(user -> user.isActive() == true).collect(Collectors.toList());

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

    public void deactivateUser(final String id) {

        Optional<User> userToDeactivate = this.userRepository.findById(id);

        if (userToDeactivate.isPresent()) {
            User user = userRepository.findById(id).get();
            user.setFinishDate(LocalDateTime.now());
            user.setActive(false);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public User editUser(final Integer id, User user) {
        Optional<User> userUpdate = this.userRepository.findById(id.toString());

        if (userUpdate.isPresent()) {
            User userToEdit = userRepository.findById(id.toString()).get();
            userToEdit.setFirstname(user.getFirstname());
            userToEdit.setLastname(user.getLastname());
            userToEdit.setIdentityCardNumber(user.getIdentityCardNumber());
            userToEdit.setAdditionalText(user.getAdditionalText());
            userToEdit.setPay(user.isPay());
            userToEdit.setRun(user.getRun());
            return user;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
