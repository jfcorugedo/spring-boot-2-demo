package com.jfcorugedo.heavydemo.users;

import com.jfcorugedo.heavydemo.users.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {

}
