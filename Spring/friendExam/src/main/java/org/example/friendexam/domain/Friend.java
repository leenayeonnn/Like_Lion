package org.example.friendexam.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString // 상황에 따라 직접 구현하는것이 좋을 수 있음
@EqualsAndHashCode
public class Friend {
    @Id // pk 지정
    private Long id;
    private String name;
    private String email;
}
