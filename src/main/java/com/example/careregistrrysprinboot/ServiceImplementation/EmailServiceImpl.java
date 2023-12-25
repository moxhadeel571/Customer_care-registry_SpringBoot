package com.example.careregistrrysprinboot.ServiceImplementation;// EmailServiceImpl.java

import com.example.careregistrrysprinboot.Repository.TeamRepository;
import com.example.careregistrrysprinboot.Service.EmailService;
import com.example.careregistrrysprinboot.Service.RecipeintService;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private RecipeintService recipeintService;
    private TeamRepository teamRepository;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, RecipeintService recipeintService, TeamRepository teamRepository) {
        this.javaMailSender = javaMailSender;
        this.recipeintService = recipeintService;
        this.teamRepository = teamRepository;
    }

    @Override
    public void sendComplaintRegistrationEmail(CareRecipient careRecipient, Email email) throws jakarta.mail.MessagingException {
        // Perform null check for email address
        if (careRecipient.getEmailAddress() == null || careRecipient.getEmailAddress().isEmpty()) {
            // Log a warning or handle the null/empty email address case appropriately
            System.out.println("Warning: Email address is null or empty for Care Recipient ID: " + careRecipient.getCareRecipientId());
            return; // Exit the method if email address is null or empty
        }

        String to = email.getTo();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Complaint Registration Successful");
        mimeMessageHelper.setFrom("care@gmail.com");
        String emailContent = "<div style='font-family: Arial, sans-serif;'>" +
                "<h2 style='color: #007bff;'>Complaint Registration Successful</h2>" +
                "<p>Dear <strong>" + careRecipient.getName() + "</strong>,</p>" +
                "<p>We are writing to inform you that your complaint has been successfully registered in our system. Below are the details of your complaint:</p>" +
                "<ul>" +
                "<li><strong>Complaint ID:</strong> " + careRecipient.getCareRecipientId() + "</li>" +
                "<li><strong>Complaint Type:</strong> " + careRecipient.getComplaintType() + "</li>" +
                "<li><strong>Order Number:</strong> " + careRecipient.getOrderNumber() + "</li>" +
                "</ul>" +
                "<p>Our team is actively working on addressing your concerns, and we appreciate your patience. We assure you that we will do our best to resolve the issue promptly.</p>" +
                "<p>Thank you for choosing our services. Your satisfaction is our priority.</p>" +
                "<p>Best Regards,<br/>The Care Registry Team</p>" +
                "</div>";

        mimeMessageHelper.setText(emailContent, true);

        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }

}
