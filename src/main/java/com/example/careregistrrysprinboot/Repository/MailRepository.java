package com.example.careregistrrysprinboot.Repository;


import com.example.careregistrrysprinboot.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Email,Long> {
}
