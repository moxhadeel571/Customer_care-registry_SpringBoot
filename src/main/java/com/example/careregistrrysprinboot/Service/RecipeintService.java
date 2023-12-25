package com.example.careregistrrysprinboot.Service;

import com.example.careregistrrysprinboot.model.CareRecipient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RecipeintService {
    List<CareRecipient> findAll();

    void saveComplaint(MultipartFile[] files, CareRecipient careRecipient) throws IOException;

    CareRecipient findBYId(Long id);

    byte[] getFileData(Long candidateId);

    String getFileName(Long candidateId);

    String getContentType(Long candidateId);
}
