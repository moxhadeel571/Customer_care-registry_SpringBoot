package com.example.careregistrrysprinboot.Controller;

import com.example.careregistrrysprinboot.Repository.ImageRepository;
import com.example.careregistrrysprinboot.Repository.RecipientRepository;
import com.example.careregistrrysprinboot.Service.CareGiverSevice;
import com.example.careregistrrysprinboot.model.CareRecipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@Controller
public class CareGiverController {
    private CareGiverSevice careGiverSevice;
    private RecipientRepository recipientRepository;
    private ImageRepository imageRepository;

@Autowired
    public CareGiverController(CareGiverSevice careGiverSevice, RecipientRepository recipientRepository, ImageRepository imageRepository) {
        this.careGiverSevice = careGiverSevice;
    this.recipientRepository = recipientRepository;
    this.imageRepository = imageRepository;
}


    @GetMapping(path="/Agent_YYasd")
    public String getCaregiverInfo() {

        return "CareGiver";
    }
@GetMapping(path="/care_view_JUVajsh")
    public  String getcareview(Model model) {
    List<CareRecipient> giverList=careGiverSevice.findAll();
    model.addAttribute("data",giverList);
    return "CareView";
}
@PostMapping("/staus_YUVujsa/{id}")
    public String getFormSave(@PathVariable("id") Long id , CareRecipient Care_Recipient){
    careGiverSevice.saveForm(id,Care_Recipient);

    return "redirect:/v1/care_view_JUVajsh";
}
    @GetMapping(path = "/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadCandidateFile(@PathVariable("id") Long candidateId) {
        byte[] fileData = recipientRepository.getFileData(candidateId);
        String fileName = recipientRepository.getFilename(candidateId);
        String contentType = recipientRepository.getContentType(candidateId);

        if (fileData != null) {
            ByteArrayResource resource = new ByteArrayResource(fileData);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);

            // Use MediaType.APPLICATION_OCTET_STREAM_VALUE as the default content type
            MediaType mediaType = contentType != null ? MediaType.parseMediaType(contentType) : MediaType.APPLICATION_OCTET_STREAM;

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(mediaType)
                    .contentLength(fileData.length)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    }






