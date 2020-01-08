package com.jfcorugedo.heavydemo.users;

import com.jfcorugedo.heavydemo.users.dto.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
}
