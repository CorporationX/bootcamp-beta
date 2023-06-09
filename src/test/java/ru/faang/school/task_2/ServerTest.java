package ru.faang.school.task_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerTest {

    @Test
    void setLoadMethod_DoseNotUpdatesLoadQuantity_IfLoadIsBiggerThanMaxLoad(){
        Server server = new Server(100.0);
        server.setLoad(120.0);
        double actualLoad = server.getLoad();
        double expectedLoad = 0.0;

        assertEquals(expectedLoad, actualLoad);
    }

    @Test
    void setLoadMethod_UpdatesLoadQuantity_IfLoadIsEqualsMaxLoad(){
        Server server = new Server(100.0);
        server.setLoad(100.0);
        double actualLoad = server.getLoad();
        double expectedLoad = 100.0;

        assertEquals(expectedLoad, actualLoad);
    }

    @Test
    void setLoadMethod_UpdatesLoadQuantity_ifLoadIsLesserMaxLoad(){
        Server server = new Server(100.0);
        server.setLoad(99.9);
        double actualLoad = server.getLoad();
        double expectedLoad = 99.9;

        assertEquals(expectedLoad, actualLoad);
    }

    @Test
    void setLoadMethod_UpdatesEnergyConsumptionByTheLoadAmount_ifThereIsMoreThanHalfLoadIncludedUsed() {
        Server server = new Server(100.0);
        server.setLoad(50.0);
        double actualEnergyConsumption = server.getEnergyConsumption();
        double expectedEnergyConsumption = 50.0;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void setLoadMethod_UpdatesEnergyConsumptionByTheHalfOfLoadAmount_IfThereIsLessThanHalfLoadUsed(){
        Server server = new Server(100.0);
        server.setLoad(49.9);
        double actualEnergyConsumption = server.getEnergyConsumption();
        double expectedEnergyConsumption = 24.95;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void getFreeResourcesMethod_WithPartialLoad() {
        Server server = new Server(100.0);
        server.setLoad(70.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 30.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }

    @Test
    void getFreeResourcesMethod_WithEqualLoad() {
        Server server = new Server(100.0);
        server.setLoad(100.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 0.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }

    @Test
    void getFreeResourcesMethod_WithEmptyLoad() {
        Server server = new Server(100.0);
        server.setLoad(0.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 100.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }
}
