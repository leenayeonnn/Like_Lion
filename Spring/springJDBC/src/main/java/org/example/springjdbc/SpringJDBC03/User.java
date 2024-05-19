package org.example.springjdbc.SpringJDBC03;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
}
