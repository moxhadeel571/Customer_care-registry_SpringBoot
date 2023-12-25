package com.example.careregistrrysprinboot.ServiceImplementation;

import com.example.careregistrrysprinboot.Repository.RecipientRepository;
import com.example.careregistrrysprinboot.Repository.TeamRepository;
import com.example.careregistrrysprinboot.Service.TeamService;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamImplementation implements TeamService {
    private RecipientRepository recipientRepository;
    private TeamRepository teamRepository;
@Autowired
    public TeamImplementation(RecipientRepository recipientRepository, TeamRepository teamRepository) {
        this.recipientRepository = recipientRepository;
    this.teamRepository = teamRepository;
}

    @Override
    public List<CareRecipient> findAll() {
    List<CareRecipient> recipients = recipientRepository.findAll();
    return recipients;
    }

    @Override
    public void saveTeam(Team team,Long id) {
    if (id!=null||team!=null) {
        teamRepository.save(team);

    }
    }
}
