package com.jfcorugedo.heavydemo.users;

import com.jfcorugedo.heavydemo.users.dto.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "users")
@Slf4j
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<User> getAll() {
        log.debug("Processing request to get all users");
        return this.usersService.getAll();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") String userId) {

        log.debug("Deleting user {1}", userId);
        this.usersService.removeOne(userId);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        return ResponseEntity.status(201).body(this.usersService.create(user));
    }
}
