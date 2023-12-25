package com.example.careregistrrysprinboot.Service;

import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Team;

import java.util.List;

public interface TeamService {
    List<CareRecipient> findAll();

    void saveTeam(Team team,Long id);
}
