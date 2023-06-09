package ru.faang.school.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServerTest {

    private Server server;

    @BeforeEach
    void setServer() {
        server = new Server(100.0);
    }


    @Test
    void setLoadMethod_trowsIllegalArgumentException_IfLoadIsBiggerThanMaxLoad() {
        assertThrows(IllegalArgumentException.class, ()->server.setLoad(120.0));
    }

    @Test
    void setLoadMethod_UpdatesLoadQuantity_IfLoadIsEqualsMaxLoad() {
        server.setLoad(100.0);
        double actualLoad = server.getLoad();
        double expectedLoad = 100.0;

        assertEquals(expectedLoad, actualLoad);
    }

    @Test
    void setLoadMethod_UpdatesLoadQuantity_ifLoadIsLesserMaxLoad() {
        server.setLoad(99.9);
        double actualLoad = server.getLoad();
        double expectedLoad = 99.9;

        assertEquals(expectedLoad, actualLoad);
    }

    @Test
    void setLoadMethod_UpdatesEnergyConsumptionByTheLoadAmount_ifThereIsMoreThanHalfLoadIncludedUsed() {
        server.setLoad(50.0);
        double actualEnergyConsumption = server.getEnergyConsumption();
        double expectedEnergyConsumption = 50.0;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void setLoadMethod_UpdatesEnergyConsumptionByTheHalfOfLoadAmount_IfThereIsLessThanHalfLoadUsed() {
        server.setLoad(49.9);
        double actualEnergyConsumption = server.getEnergyConsumption();
        double expectedEnergyConsumption = 24.95;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void getFreeResourcesMethod_WithPartialLoad() {
        server.setLoad(70.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 30.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }

    @Test
    void getFreeResourcesMethod_WithEqualLoad() {
        server.setLoad(100.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 0.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }

    @Test
    void getFreeResourcesMethod_WithEmptyLoad() {
        server.setLoad(0.0);
        double actualFreeResources = server.getFreeResources();
        double expectedFreeResources = 100.0;

        assertEquals(expectedFreeResources, actualFreeResources);
    }
}
