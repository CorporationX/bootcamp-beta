package ru.faang.school.task_2;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption, double load) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption * (load / 2);
    }

    public double getFreeResources() {
        return getMaxLoad() - getLoad();
    }

    public void setLoad(double load) {
        if (load <= maxLoad) {
            this.load = load;
            updateEnergyConsumption();
        } else {
            System.out.println("There is not enough resources on this server");
        }
    }

    private void updateEnergyConsumption() {
        this.energyConsumption = energyConsumption * (load / 2);
    }
}
