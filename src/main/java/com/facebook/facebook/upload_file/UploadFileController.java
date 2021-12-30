package com.facebook.facebook.upload_file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@CrossOrigin("*")
@RestController

public class UploadFileController {

    //
    @Autowired
    UploadFileService uploadFileService;
    //

    @CrossOrigin
    @PostMapping("uploadFile")
    public ResponseEntity<Map> updateImage(@RequestParam(required = false) String id,
                                           @RequestParam(required = false) String typeFile,
    @RequestParam(required = false) MultipartFile multipartFile,
    @RequestParam(required = false) String publicId) throws IOException {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setId(id);
        uploadFile.setMultipartFile(multipartFile);
        uploadFile.setTypeFile(typeFile);
        uploadFile.setPublicId(publicId);
        Map result = uploadFileService.uploadFile(uploadFile);
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
