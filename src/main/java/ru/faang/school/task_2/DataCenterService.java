package ru.faang.school.task_2;

import java.util.List;

public class DataCenterService implements OptimizationStrategy {

    private DataCenter dataCenter;
    private ResourceRequest request;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getTotalEnergyConsumption();
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void allocateResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        double neededResources = request.getLoad();

        for (Server server : servers) {
            if (neededResources == 0) {
                break;
            }

            double serverFreeResources = server.getFreeResources();
            if (serverFreeResources != 0) {

                if (neededResources >= serverFreeResources) {
                    server.setLoad(server.getLoad() + serverFreeResources);
                    neededResources -= serverFreeResources;
                } else if (neededResources < serverFreeResources) {
                    server.setLoad(server.getLoad() + neededResources);
                    neededResources = 0;
                }
            }
        }

        dataCenter.setServers(servers);
    }

    public void releaseResources(ResourceRequest request) {
        List<Server> servers = dataCenter.getServers();
        double resourcesToRelease = request.getLoad();

        for (Server server : servers) {
            double serverLoad = server.getLoad();

            if (serverLoad >= resourcesToRelease) {
                server.setLoad(serverLoad - resourcesToRelease);
                break;
            } else {
                server.setLoad(0);
                resourcesToRelease -= serverLoad;
            }
        }

        dataCenter.setServers(servers);
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        request = new ResourceRequest(dataCenter.getTotalServersLoad());
        dataCenter.sortServersByMaxLoad();
        dataCenter.setServersLoadToZero();
        allocateResources(request);
    }
}
