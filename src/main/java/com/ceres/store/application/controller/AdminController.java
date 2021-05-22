package com.ceres.store.application.controller;

import java.util.List;

import com.ceres.store.application.dto.OrderDto;
import com.ceres.store.application.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/notice/list/{userId}")
    public List<OrderDto> notice(@PathVariable("userId") Long id) {
        return adminService.notice(id);
    }

    @GetMapping(value = "/notice/old/order/list/{userId}")
    public List<OrderDto> oldOrder(@PathVariable("userId") Long id) {
        return adminService.oldOrder(id);
    }

    @GetMapping(value = "/notice/my/order/list/{userId}")
    public List<OrderDto> myOrder(@PathVariable("userId") Long id) {
        return adminService.myOrder(id);
    }

    @GetMapping(value = "/notice/clear/{userId}")
    public void clearNotice(@PathVariable("userId") Long id) {
        adminService.clear(id);
    }


}
