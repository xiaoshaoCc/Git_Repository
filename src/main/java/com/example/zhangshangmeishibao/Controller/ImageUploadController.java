package com.example.zhangshangmeishibao.Controller;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageUploadController {

    @PostMapping("/upload")
    public String Upload(@RequestParam("file") MultipartFile multipartFile){
        String filename=multipartFile.getOriginalFilename();
        if (filename != null) {
            Path filePath = Paths.get("/resources/Image",filename);
            try {
                multipartFile.transferTo(filePath.toFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "上传成功";
        }else{
            return "上传失败";
        }
    }
}
