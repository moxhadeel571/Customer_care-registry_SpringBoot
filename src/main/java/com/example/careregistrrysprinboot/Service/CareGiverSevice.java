package com.example.careregistrrysprinboot.Service;


import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Care_Giver;

import java.util.List;
import java.util.Optional;

public interface CareGiverSevice {
    List<CareRecipient> findAll();

    void save(Care_Giver careGiver);

    Optional<Care_Giver> findById(Long id);

    void saveForm(Long id, CareRecipient careGiver);
}
