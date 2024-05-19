package org.example.springjdbc.SpringJDBC03;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

// 결과 집합 전체를 단일 객체 하나로 반환하는데 좋음
// 특정 조건에 따라 다양한 타입의 객체 리스트를 추가할 때 사용 가능
// ResultSet 은 레코드 수마다 매번 실행하는 반면
// Extractor 는 집합을 처리해줌

// ex) 유저당 여러 roll 리스트를 체워주기
public class UserResultSetExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
        }
        return user;
    }
}
