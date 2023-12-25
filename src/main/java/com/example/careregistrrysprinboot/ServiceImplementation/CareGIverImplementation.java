package com.example.careregistrrysprinboot.ServiceImplementation;

import com.example.careregistrrysprinboot.Repository.CareGiverRepository;
import com.example.careregistrrysprinboot.Repository.RecipientRepository;
import com.example.careregistrrysprinboot.Service.CareGiverSevice;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Care_Giver;
import com.example.careregistrrysprinboot.model.CareRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CareGIverImplementation implements CareGiverSevice {
    private RecipientRepository caareRecipient;
    private CareGiverRepository careGiverRepository;
@Autowired
    public CareGIverImplementation(RecipientRepository caareRecipient, CareGiverRepository careGiverRepository) {
        this.caareRecipient = caareRecipient;
    this.careGiverRepository = careGiverRepository;
}


    @Override
    public List<CareRecipient> findAll() {
    List<CareRecipient> careGiverList = caareRecipient.findAll();
    return careGiverList;
    }

    @Override
    public void save(Care_Giver careGiver) {
        careGiverRepository.save(careGiver);
    }

    @Override
    public Optional<Care_Giver> findById(Long id) {
    Optional<Care_Giver> careGiver=careGiverRepository.findById(id);
    return careGiver;
    }

    @Override
    public void saveForm(Long id, CareRecipient careRecipient) {
        if (id != null) {
            CareRecipient existingCareRecipient = caareRecipient.findById(id).orElse(null);

            if (existingCareRecipient != null) {
                existingCareRecipient.setStatus(careRecipient.getStatus());
                // Use the correct entity for the save operation
                caareRecipient.save(existingCareRecipient);
            }
        }
    }

}
