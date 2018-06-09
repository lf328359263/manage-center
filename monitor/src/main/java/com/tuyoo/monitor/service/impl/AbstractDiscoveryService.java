package com.tuyoo.monitor.service.impl;

import com.tuyoo.monitor.entities.ServerInstance;
import com.tuyoo.monitor.service.DiscoveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@Slf4j
public abstract class AbstractDiscoveryService implements DiscoveryService {

    @Autowired
    protected DiscoveryClient discoveryClient;

//    private String managementContextPath = "";
//    private String infoUrl = "/info";
//    private String metricsUrl = "/metrics";

    @Override
    public List<String> getServices() {
        return discoveryClient.getServices();
    }

    @Override
    public int getTotalInstances() {
        int sum = 0;
        for (String service: getServices()){
            sum += discoveryClient.getInstances(service).size();
        }
        return sum;
    }

    @Override
    public void fillInstanceInfo(ServerInstance serverInstance) {
//        discoveryClient.
    }

    @Override
    public void fillInstanceMetrics(ServerInstance serverInstance) {

    }
}
