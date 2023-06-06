package ru.faang.school.task_2;

import java.util.List;

public class DataCenterService {

    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public double getTotalEnergyConsumption() {
        List<Server> servers = dataCenter.getServers();
        double totalEnergyConsumption = 0.0;

        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void allocateResources(ResourceRequest request) {
    }

    public void releaseResources(ResourceRequest request) {
    }
}
