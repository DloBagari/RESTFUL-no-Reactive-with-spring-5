package org.springrest.simplerestAppnoReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * passes the MultipartFile to FileUploaderService
 */

@RestController
@RequestMapping("/file")
public class FileLoaderController {
    @Autowired
    FileUploader fileUploader;

    @ResponseBody
    @RequestMapping(value = "/loadfile", method = RequestMethod.POST)
    public Map<String, Object> uploadFile(@RequestParam("file")MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        try {
            fileUploader.uploadFile(file);
            map.put("File upload", "ok");
        } catch (IOException e) {
            map.put("File upload", e.getMessage());
        }
        return map;
    }
}
