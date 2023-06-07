package ru.faang.school.task_2;


public class DataCenterService implements OptimizationStrategy {

    private DataCenter dataCenter;

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
        double neededResources = request.getLoad();

        for(Server server : dataCenter.getServers()){
            double freeResources = server.getFreeResources();

            if(neededResources <= freeResources){
                server.setLoad(neededResources);
                break;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        double resourcesToRelease = request.getLoad();

        for (Server server : dataCenter.getServers()) {
            double serverLoad = server.getLoad();

            if (serverLoad >= resourcesToRelease){
                server.setLoad(serverLoad - resourcesToRelease);
                break;
            }else{
                server.setLoad(0);
                resourcesToRelease -= serverLoad;
            }
        }
    }

    @Override
    public void optimize(DataCenter dataCenter) {

    }
}
