package com.facebook.facebook.upload_file;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
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

    public void deleteFile(UploadFile uploadFile) throws IOException {
        cloudinary.uploader().destroy("Avatars/1644752768557.jpg",ObjectUtils.asMap(
                "public_id", "Avatars/1644752768557.jpg",
                "overwrite", true,
                "resource_type", "image"
        ));
    }

    public Map uploadBase64(UploadBase64 uploadBase64) throws IOException {
        Map result = cloudinary.uploader().upload(uploadBase64.getBase64(), ObjectUtils.asMap(
                "public_id", uploadBase64.getPublicId() + uploadBase64.getId(),
                "overwrite", true,
                "resource_type", uploadBase64.getTypeFile()
        ));
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
