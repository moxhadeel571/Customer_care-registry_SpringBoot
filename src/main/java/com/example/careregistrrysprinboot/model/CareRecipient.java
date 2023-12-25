package com.example.careregistrrysprinboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
        @Table(name = "care_recipient")
public class
CareRecipient {  // Renamed class to follow Java naming conventions
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long careRecipientId;  // Renamed field to follow Java naming conventions
    private String name;
    private String productName;  // Renamed field to follow Java naming conventions
    private String description;
    private String typeOfProduct;
    private Date purchaseDate;
    @OneToMany
    @JoinTable(
            name = "care_recipient_images",
            joinColumns = @JoinColumn(name = "care_recipient_care_recipient_id"),
            inverseJoinColumns = @JoinColumn(name = "images_id")
    )
    private List<Image> images;
    private String contactNumber;
    private String emailAddress;
    private String address;
    private Date incidentDateTime;
    private String complaintType;
    private String orderNumber;
    private String severityLevel;
    private String status;  // Renamed field to follow Java naming conventions
//    private boolean termsAndConditionsAgreement;
}
