package ru.faang.school.task_2;

import lombok.Getter;

@Getter
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public double getFreeResources() {
        return getMaxLoad() - getLoad();
    }

    public void setLoad(double load) {
        if (load <= maxLoad) {
            this.load = load;
            updateEnergyConsumption();
        } else {
            throw new IllegalArgumentException("There is not enough space in the server to accommodate the load");
        }
    }

    private void updateEnergyConsumption() {
        if (load > maxLoad / 2){
            this.energyConsumption += load;
        }else {
            this.energyConsumption += (load / 2);
        }
    }
}
