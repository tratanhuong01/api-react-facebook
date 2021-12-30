package com.facebook.facebook.upload_file;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service

public class UploadFileService {

    Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    public UploadFileService() {
        valuesMap.put("cloud_name", "ensonet-dev");
        valuesMap.put("api_key", "625767877926127");
        valuesMap.put("api_secret", "TSaPPlz96fO4w7hGf-Qtx3k25mo");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map uploadFile(UploadFile uploadFile) throws IOException {
        File file = convert(uploadFile.getMultipartFile());
        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", uploadFile.getPublicId() + uploadFile.getId(),
                "overwrite", true,
                "resource_type", uploadFile.getTypeFile()
        ));
        file.delete();
        return result;
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
