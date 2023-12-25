package com.example.careregistrrysprinboot.Controller;

import com.example.careregistrrysprinboot.Repository.TeamRepository;
import com.example.careregistrrysprinboot.Service.EmailService;
import com.example.careregistrrysprinboot.Service.RecipeintService;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Email;
import com.example.careregistrrysprinboot.model.Team;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/v2")
public class ReceipientController {

private RecipeintService recipeintService;
private EmailService emailService;
private TeamRepository teamRepository;
@Autowired
    public ReceipientController(RecipeintService recipeintService, EmailService emailService, TeamRepository teamRepository) {
        this.recipeintService = recipeintService;
    this.emailService = emailService;
    this.teamRepository = teamRepository;
}
    @GetMapping(path="/recipient" )
    public String getRecipient(Model model) {
    List<CareRecipient> careRecipients=recipeintService.findAll();
        return "Customer";
    }
    @GetMapping(path = "/ComplainForm_YbBKN")
    public String getComplainForm() {
        return "Customer_form";

}
@GetMapping("/FinalStatus")
public String getFinalStatus(Model model) {
    List<Team> team=teamRepository.findAll();
    model.addAttribute("FinalStatus", team);
    return "Chat";
}


    @PostMapping(path = "/saveComplaint")
    public String saveComplaint(
            @RequestParam("files") MultipartFile[] files,
            @ModelAttribute Email email,
            CareRecipient careRecipient) throws IOException, MessagingException {

        // Ensure the "to" attribute in @ModelAttribute matches the form field name
        emailService.sendComplaintRegistrationEmail(careRecipient, email);


        // Save complaint
        recipeintService.saveComplaint(files, careRecipient);

        return "Customer";
    }

    @GetMapping(path="/status")
    public String getComplaint(Model model) throws IOException {
        List<Team> team=teamRepository.findAll();
        model.addAttribute("team", team);
        return "status";

}




}
