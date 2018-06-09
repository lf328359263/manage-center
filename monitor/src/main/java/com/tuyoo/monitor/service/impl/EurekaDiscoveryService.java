package com.tuyoo.monitor.service.impl;

import com.netflix.appinfo.InstanceInfo;
import com.tuyoo.monitor.entities.ServerInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EurekaDiscoveryService extends AbstractDiscoveryService {

    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;

    @Override
    public List<InstanceInfo> getServerInstances(String serviceName) {
        List<InstanceInfo> instances = new ArrayList<>();

        for(ServiceInstance instance: eurekaDiscoveryClient.getInstances(serviceName)){
            InstanceInfo instanceInfo = ((EurekaDiscoveryClient.EurekaServiceInstance) instance).getInstanceInfo();
            instances.add(instanceInfo);
        }

        return instances;
    }

    @Override
    public List<InstanceInfo> getAllServerInstances() {
        List<InstanceInfo> instances = new ArrayList<>();
        for (String service: getServices()){
            instances.addAll(getServerInstances(service));
        }
        return instances;
    }
}
