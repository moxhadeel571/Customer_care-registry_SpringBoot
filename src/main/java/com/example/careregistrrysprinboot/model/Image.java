package com.example.careregistrrysprinboot.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contentType;
    @Lob
    @Column(name = "data", columnDefinition = "MEDIUMBLOB")
    private byte[] data;




    // Other properties...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
