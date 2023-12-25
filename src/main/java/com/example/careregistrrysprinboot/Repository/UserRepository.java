package com.example.careregistrrysprinboot.Repository;

import com.example.careregistrrysprinboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT u FROM users u WHERE u.email = ?")
    User findFirstByEmail(@Param("email") String email);

}