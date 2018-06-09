package com.tuyoo.monitor.controller;

import com.alibaba.fastjson.JSON;
import com.tuyoo.monitor.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ServerController {

    @Autowired
    private DiscoveryService discoveryService;

    @GetMapping("/services")
    public String services(Map<String, Object> model){
        model.put("instancesNum", discoveryService.getTotalInstances());
        model.put("serviceList", discoveryService.getAllServerInstances());
        return JSON.toJSONString(model);
    }
}
