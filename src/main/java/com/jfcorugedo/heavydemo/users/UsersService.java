package com.jfcorugedo.heavydemo.users;

import com.jfcorugedo.heavydemo.users.dto.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAll() {

        return this.usersRepository.findAll();
    }

    public void removeOne(String userId) {
        this.usersRepository.delete(new User().setId(userId));
    }
}
