package com.example.careregistrrysprinboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="care_giver")
public class Care_Giver {
    @Id
    private int id;
    private String username;
    private String branchname;
    private String techinicalname;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone_Number;
    private String Experience;
    private String email;

}
