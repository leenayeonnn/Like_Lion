package com.example.springmvcfriendexam.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private long id;

    @NotEmpty(message = "name can not be empty")
    private String name;

    @Email(message = "this email is not enable")
    @NotEmpty(message = "email can not be empty")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Friend friend = (Friend) o;
        return id == friend.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
