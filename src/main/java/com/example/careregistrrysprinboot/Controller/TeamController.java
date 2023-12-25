package com.example.careregistrrysprinboot.Controller;

import com.example.careregistrrysprinboot.Service.TeamService;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("v3")
@Controller
public class TeamController {
    private TeamService teamService;
@Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping(path="/teamdashboard")
public String teamDashboard(){

    return "Team";
}
@GetMapping("/chat")
public String chat(){

    return "Chat";
}
@GetMapping(path="/saveDecision")
    public String saveDecision(Model model){
    List<CareRecipient> careRecipientList=teamService.findAll();
    model.addAttribute("careRecipientList",careRecipientList);
    return "TeamStatus";
}
@PostMapping("/saveDecision/{id}")
    public String saveDecision(Team team,@PathVariable("id") Long id){
    teamService.saveTeam(team,id);
    return "redirect:/v3/teamdashboard";
}

}
