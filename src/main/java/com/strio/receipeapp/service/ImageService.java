package com.strio.receipeapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long valueOf, MultipartFile file);
}
