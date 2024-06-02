package org.example.springdatajpa.example1;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User("saveTest", "saveTest@email.com");
        userRepository.save(user);

        System.out.println(user.getId());
    }

    @Test
    void findByName() {
        List<User> users = userRepository.findByName("test");
        assertThat(users.size()).isEqualTo(2);

        List<User> users2 = userRepository.findByName("lee");
        assertThat(users2.size()).isEqualTo(1);

    }

    @Test
    void findByEmail() {
        List<User> users = userRepository.findByEmail("lee@email.com");
        users.forEach(user -> assertThat(user.getName()).isEqualTo("lee"));
    }

    @Test
    void findByNAmeAndEmail() {
        List<User> users = userRepository.findByNameAndEmail("test", "test@email.com");
        assertThat(users.size()).isEqualTo(2);

        List<User> users2 = userRepository.findByNameAndEmail("test", "noTest@email.com");
        assertThat(users2.size()).isEqualTo(0);
    }

    @Test
    void findByNameOrEmail() {
        List<User> users = userRepository.findByNameOrEmail("test", "test@email.com");
        assertThat(users.size()).isEqualTo(2);

        List<User> users2 = userRepository.findByNameOrEmail("test", "noTest@email.com");
        assertThat(users2.size()).isEqualTo(2);
    }

    @Test
    void updateEmail() {
        userRepository.updateUserEmail(3L, "newTest@email.com");

        Optional<User> users = userRepository.findById(3L);

        assertThat(users.get().getEmail()).isEqualTo("newTest@email.com");
    }

    @Test
    void deleteByEmail() {
        userRepository.deleteByEmail("test@email.com");
        List<User> users = userRepository.findByEmail("test@email.com");
        assertThat(users.size()).isEqualTo(0);
    }

    //// 네이티브 sql

    @Test
    void findByEmailNative() {
        List<User> users = userRepository.findByEmailNative("lee@email.com");
        List<UserDTO> userDTOs = users
                .stream()
                .map(result -> new UserDTO(result.getName(), result.getEmail()))
                .toList();

        assertThat(userDTOs).extracting(UserDTO::getName).containsExactly("lee");
    }

    @Test
    void findUsersByNameNative() {
        List<Object[]> users = userRepository.findUsersByNameNative("e");
        List<UserDTO> userDTOs = users
                .stream()
                .map(result -> new UserDTO((String) result[0], (String) result[1]))
                .toList();

        assertThat(userDTOs.size()).isEqualTo(3);
    }
}