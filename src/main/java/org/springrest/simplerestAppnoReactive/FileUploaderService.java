package org.springrest.simplerestAppnoReactive;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploaderService implements FileUploader {
    private Path path;

    public FileUploaderService() throws IOException {
        this.path = Paths.get("/home/ubuntu/uploaded_files");
        Files.createDirectories(this.path);
    }
    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        //clean the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //if the file is empty throw exception
        if (fileName.isEmpty()) {
            throw new IOException("file is empty");
        }
        //copy the file from client to server
        try {
            Files.copy(file.getInputStream(), path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
