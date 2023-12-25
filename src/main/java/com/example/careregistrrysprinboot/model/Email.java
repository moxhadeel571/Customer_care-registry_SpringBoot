package com.example.careregistrrysprinboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Email {
    @Id
    private Long id;
    private String from;
    private String to;
    private String subject;
    private String body;
}
