package org.example.springjdbc.SpringJDBC05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
