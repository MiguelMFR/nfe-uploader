package com.miguelmfr.nfe.dto;

import org.springframework.web.multipart.MultipartFile;

public record NFeRequestDTO(
        MultipartFile file
) {

}
