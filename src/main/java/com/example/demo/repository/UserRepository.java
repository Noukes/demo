package com.example.demo.repository;

import com.example.demo.model.Gender;
import com.example.demo.model.User;
import jakarta.persistence.SecondaryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("select user from User user where " +
            "(:gender = 'ANY' or user.gender = :gender) and" +
            "(user.dateOfBirth >= :minDateBirth) and user.dateOfBirth <= :maxDateBirth")
    List<User> findCompatibleUsers(
            @Param("gender") Gender gender,
            @Param("minDateBirth") LocalDate minDateBirth,
            @Param("maxDateBirth") LocalDate maxDateBirth
    );
}
