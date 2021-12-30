package com.facebook.facebook.upload_file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter

public class UploadFile {

    String id;
    String publicId;
    MultipartFile multipartFile;
    String typeFile;

}
