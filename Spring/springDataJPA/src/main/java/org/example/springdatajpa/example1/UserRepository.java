package org.example.springdatajpa.example1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    List<User> findByEmail(String email);

    List<User> findByNameAndEmail(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    // Jpql 기준이기에 entity 기준으로 작성해야함
    @Modifying
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    int updateUserEmail(@Param("id") Long id, @Param("email") String email);

    @Modifying
    @Query("DELETE FROM User u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);

    //// 네이티브 기준 : nativeQuery 옵션을 true로 설정
    @Query(value = "SELECT * FROM jpa_user WHERE email LIKE %?1%", nativeQuery = true)
    List<User> findByEmailNative(String email);

    @Query(value = "SELECT name, email FROM jpa_user WHERE name LIKE %:name%", nativeQuery = true)
    List<Object[]> findUsersByNameNative(@Param("name") String name);

}
