package com.example.careregistrrysprinboot.Repository;

import com.example.careregistrrysprinboot.model.CareRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<CareRecipient, Long> {
    @Query("SELECT i.data FROM Image i WHERE i.id = :id")
    byte[] getFileData(@Param("id") Long id);

    @Query("SELECT i.contentType FROM Image i WHERE i.id = :id")
    String getContentType(@Param("id") Long id);

    @Query("SELECT i.name FROM Image i WHERE i.id = :id")
    String getFilename(@Param("id") Long id);

}
