package org.example.springmvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm2 {
    @NotEmpty(message = "user name can not be empty")
    @Size(min = 4, max = 20, message = "user name size : 4 ~ 20")
    private String username;

    @NotEmpty(message = "password can not be empty")
    @Size(min = 6, max = 12, message = "password size : 6 ~ 12")
    private String password;
}
