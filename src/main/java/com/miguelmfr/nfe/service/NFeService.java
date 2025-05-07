package com.miguelmfr.nfe.service;

import com.miguelmfr.nfe.dto.NFeRequestDTO;
import com.miguelmfr.nfe.dto.NFeResponseDTO;
import com.miguelmfr.nfe.port.StoragePort;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

@Service
public class NFeService {
    private final StoragePort s3Repository;

    public NFeService(StoragePort s3Repository) {
        this.s3Repository = s3Repository;
    }

    public NFeResponseDTO uploadNFe(NFeRequestDTO request) throws Exception {
        String url = s3Repository.uploadNFe(request.file());

        return new NFeResponseDTO(url);
    }
}
