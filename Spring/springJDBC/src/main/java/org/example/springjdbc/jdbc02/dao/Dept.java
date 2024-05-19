package org.example.springjdbc.jdbc02.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Dept {
    private long id;
    private String name;
    private String loc;
}
