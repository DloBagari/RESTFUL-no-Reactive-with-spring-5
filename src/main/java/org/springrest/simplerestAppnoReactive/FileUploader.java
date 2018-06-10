package org.springrest.simplerestAppnoReactive;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploader {
    public void uploadFile(MultipartFile file ) throws IOException;
}
