package com.miguelmfr.nfe.port;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StoragePort {
    String uploadNFe(MultipartFile file) throws IOException;
}
