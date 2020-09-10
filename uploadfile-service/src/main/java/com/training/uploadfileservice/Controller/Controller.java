package com.training.uploadfileservice.Controller;

import com.training.uploadfileservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller {


    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file")MultipartFile file) throws Exception {
        service.uploadfile(file);

    }


}
