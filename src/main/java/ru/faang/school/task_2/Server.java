package ru.faang.school.task_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }
}
