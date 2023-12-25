package com.example.careregistrrysprinboot.Repository;

import com.example.careregistrrysprinboot.model.Care_Giver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareGiverRepository extends JpaRepository<Care_Giver, Long> {
}
