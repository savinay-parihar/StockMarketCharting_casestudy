package com.training.uploadfileservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface Service {
    void uploadfile(MultipartFile file) throws Exception;
}
