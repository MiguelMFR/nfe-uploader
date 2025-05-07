package com.miguelmfr.nfe.controller;

import com.miguelmfr.nfe.dto.NFeRequestDTO;
import com.miguelmfr.nfe.dto.NFeResponseDTO;
import com.miguelmfr.nfe.service.NFeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nfe")
public class NFeController {
    private final NFeService nFeService;

    public NFeController(NFeService nFeService) {
        this.nFeService = nFeService;
    }
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<NFeResponseDTO> uploadNFe(@ModelAttribute NFeRequestDTO request) {

        try {
            NFeResponseDTO response = this.nFeService.uploadNFe(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
