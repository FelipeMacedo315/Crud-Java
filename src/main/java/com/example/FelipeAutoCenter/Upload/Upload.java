package com.example.FelipeAutoCenter.Upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Upload {
    public List<String> Upload_Image(MultipartFile[] files) throws IOException {
        File pathGallery = new File("Gallery");
        List<String> urlPathImgs = new ArrayList<>();
        for (MultipartFile img : files) {
            File imgVehicle = new File(pathGallery, img.getOriginalFilename());
            imgVehicle.createNewFile();

            urlPathImgs.add(imgVehicle.getAbsolutePath());
        }

        return urlPathImgs;
    }
}
