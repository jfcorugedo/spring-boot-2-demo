package com.jfcorugedo.heavydemo.users.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors( chain = true )
public class User {

    private String id;
    private String name;
    private String surname;
    private Role role;

}
