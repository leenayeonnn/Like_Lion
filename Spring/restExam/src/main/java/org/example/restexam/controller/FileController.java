package org.example.restexam.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.example.restexam.domain.UploadInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestPart("info")UploadInfo uploadInfo
    ) {
        String message = "";
        //
        System.out.println(file.getOriginalFilename() + "=======================");
        System.out.println(uploadInfo.getDescription()+"=======================");
        System.out.println(uploadInfo.getTag()+"=======================");

        try {
            InputStream inputStream = file.getInputStream();
            StreamUtils.copy(inputStream,
                    new FileOutputStream(
                            "C:/Like_Lion_BE10/workspace/Spring/restExamUpload/" + file.getOriginalFilename()));

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.ok().body(message);
        } catch (IOException e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.badRequest().body(message);
        }
    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        Path filePath = Paths.get("C:/Like_Lion_BE10/workspace/Spring/restExamUpload/cat.jpg");
        response.setContentType("image/jpeg");

        try{
            InputStream inputStream = Files.newInputStream(filePath);
            StreamUtils.copy(inputStream,response.getOutputStream());
            response.flushBuffer();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
