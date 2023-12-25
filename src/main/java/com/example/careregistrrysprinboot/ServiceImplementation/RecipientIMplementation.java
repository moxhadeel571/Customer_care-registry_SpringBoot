package com.example.careregistrrysprinboot.ServiceImplementation;

import com.example.careregistrrysprinboot.Repository.ImageRepository;
import com.example.careregistrrysprinboot.Repository.RecipientRepository;
import com.example.careregistrrysprinboot.Service.RecipeintService;
import com.example.careregistrrysprinboot.model.CareRecipient;
import com.example.careregistrrysprinboot.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipientIMplementation implements RecipeintService {

    private RecipientRepository recipientRepository;
    private ImageRepository imageRepository;
@Autowired
    public RecipientIMplementation(RecipientRepository recipientRepository, ImageRepository imageRepository) {
        this.recipientRepository = recipientRepository;
    this.imageRepository = imageRepository;
}

    @Override
    public List<CareRecipient> findAll() {
        List<CareRecipient> recipients=recipientRepository.findAll();

        return recipients;
    }
    @Override
    public void saveComplaint(MultipartFile[] files, CareRecipient careRecipient) throws IOException {
        if (files != null) {
            List<Image> images = new ArrayList<>();

            for (MultipartFile file : files) {
                Image image = new Image();
                image.setName(file.getOriginalFilename());
                image.setData(file.getBytes());
                image.setContentType(file.getContentType());
                images.add(image);
            }

            // Save the Image entities before setting them in careRecipient
            List<Image> savedImages = new ArrayList<>();
            for (Image image : images) {
                savedImages.add(imageRepository.save(image));
            }

            // Set the saved Images in the careRecipient
            careRecipient.setImages(savedImages);

            // Now save the careRecipient entity
            recipientRepository.save(careRecipient);
        }
    }



    @Override
    public CareRecipient findBYId(Long id) {
        CareRecipient careRecipient = recipientRepository.findById(id).orElse(null);
        return careRecipient;
    }

    @Override
    public byte[] getFileData(Long candidateId) {
        try {
            byte[] foundData=recipientRepository.getFileData(candidateId);
            if (foundData!=null){
                return foundData;
            }else{
                throw new RuntimeException("file not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving file data", e);

        }
        }

    @Override
    public String getFileName(Long candidateId) {
        try {
            String filename = recipientRepository.getFilename(candidateId);
            if (filename != null) {
                return filename;
            } else {
                throw new RuntimeException("Filename not found for file with id: " + candidateId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving filename", e);
        }

    }

    @Override
    public String
    getContentType(Long candidateId) {
        try {
            String contentType = recipientRepository.getContentType(candidateId);
            if (contentType != null) {
                return contentType;
            } else {
                throw new RuntimeException("Content type not found for file with id: " + candidateId);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving content type", e);
        }
    }


}


