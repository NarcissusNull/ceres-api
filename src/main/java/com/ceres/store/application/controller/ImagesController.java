package com.ceres.store.application.controller;

import com.ceres.store.infrastructure.MinioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/img")
public class ImagesController {

    @Autowired
    private MinioRepository minioRepository;

    @GetMapping(value = "/{imgName}")
    public byte[] getImage(@PathVariable("imgName") String imgName){
        return minioRepository.download("goods", imgName);
    }
    
}
