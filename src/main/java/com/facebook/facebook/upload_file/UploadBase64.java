package com.facebook.facebook.upload_file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter

public class UploadBase64 {

    String id;
    String publicId;
    String base64;
    String typeFile;

}
