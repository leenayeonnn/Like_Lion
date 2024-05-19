package org.example.springjdbc.SpringJDBC05;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    // 입력시 자동으로 생성된 pk 값 리턴 => SimpleJdbcInsert
    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("users")
                .usingGeneratedKeyColumns("id");
    }

    public User insertUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());

        Number pk =  simpleJdbcInsert.executeAndReturnKey(params);
        user.setId(pk.longValue());
        return user;
    }
}
