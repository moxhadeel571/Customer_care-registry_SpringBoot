package com.example.careregistrrysprinboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "care_recipient")
public class Team {
    @Id
    private Long id;
    private String Approval;
    @OneToMany
    private List<CareRecipient> carelist;
}
