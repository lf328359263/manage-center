package com.tuyoo.monitor.service;

import com.netflix.appinfo.InstanceInfo;
import com.tuyoo.monitor.entities.ServerInstance;

import java.util.List;

public interface DiscoveryService {

    List<String> getServices();

    List<InstanceInfo> getServerInstances(String serviceName);

    List<InstanceInfo> getAllServerInstances();

    int getTotalInstances();

    void fillInstanceInfo(ServerInstance serverInstance);

    void fillInstanceMetrics(ServerInstance serverInstance);


}
