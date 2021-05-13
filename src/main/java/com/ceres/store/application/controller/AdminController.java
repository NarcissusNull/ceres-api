package com.ceres.store.application.controller;

import java.util.List;

import com.ceres.store.application.service.AdminService;
import com.ceres.store.entity.GoodsEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/types")
    public void createTypes(@RequestBody List<String> types) {
        adminService.createTypes(types);
    }

    @GetMapping(value = "/notice/list/{userid}")
    public List<GoodsEntity> notice() {

    }

}
