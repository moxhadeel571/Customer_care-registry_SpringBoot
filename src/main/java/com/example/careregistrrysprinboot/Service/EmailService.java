package com.example.careregistrrysprinboot.Service;


import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Email;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;


@Service
public interface EmailService {


    void sendComplaintRegistrationEmail(CareRecipient careRecipient, Email email) throws MessagingException;
}
