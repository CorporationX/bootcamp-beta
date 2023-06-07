package ru.faang.school.task_2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DataCenter {

    private List<Server> servers;

    public DataCenter() {
        servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void removeServer(Server server) {
        servers.remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergyConsumption = 0.0;

        for (Server server : servers) {
            totalEnergyConsumption += server.getEnergyConsumption();
        }

        return totalEnergyConsumption;

    }

    public double getTotalServersFreeCapacity() {
        return getTotalServersMaxLoad() - getTotalServersLoad();
    }

    public double getTotalServersLoad() {
        double totalLoad = 0.0;

        for (Server server : servers) {
            totalLoad += server.getLoad();
        }

        return totalLoad;
    }

    public double getTotalServersMaxLoad() {
        double totalMaxLoad = 0.0;

        for (Server server : servers) {
            totalMaxLoad += server.getMaxLoad();
        }

        return totalMaxLoad;
    }
}
