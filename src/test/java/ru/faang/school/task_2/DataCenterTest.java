package ru.faang.school.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DataCenterTest {

    private DataCenter dataCenter;
    private Server server1;
    private Server server2;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        server1 = new Server(100.0);
        server2 = new Server(200.0);
        dataCenter.addServer(server1);
        dataCenter.addServer(server2);
    }

    @Test
    void removeServerMethod_Test() {
        dataCenter.removeServer(server2);

        assertEquals(1, dataCenter.getServers().size());
        assertFalse(dataCenter.getServers().contains(server2));
    }

    @Test
    void getTotalEnergyConsumptionMethod_Test() {
        server1.setLoad(40.0);
        server2.setLoad(100.0);
        double actualEnergyConsumption = dataCenter.getTotalEnergyConsumption();
        double expectedEnergyConsumption = 120.0;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void getTotalServersFreeCapacity_Test() {
        server1.setLoad(20.0);
        server2.setLoad(100.0);
        double actualServersFreeCapacity = dataCenter.getTotalServersFreeCapacity();
        double expectedFreeCapacity = 180.0;

        assertEquals(expectedFreeCapacity, actualServersFreeCapacity);
    }

    @Test
    void getTotalServersLoad_Test() {
        server1.setLoad(20.0);
        server2.setLoad(100.0);
        double actualServersLoad = dataCenter.getTotalServersLoad();
        double expectedServersLoad = 120.0;

        assertEquals(expectedServersLoad, actualServersLoad);
    }

    @Test
    void getTotalServersMaxLoad_Test() {
        double actualServersMaxLoad = dataCenter.getTotalServersMaxLoad();
        double expectedServersMaxLoad = 300.0;

        assertEquals(expectedServersMaxLoad, actualServersMaxLoad);
    }

    @Test
    void sortServersByMaxLoadMethod_Test() {
        Server server3 = new Server(150.0);
        dataCenter.addServer(server3);

        dataCenter.sortServersByMaxLoad();

        assertEquals(server1, dataCenter.getServers().get(0));
        assertEquals(server3, dataCenter.getServers().get(1));
        assertEquals(server2, dataCenter.getServers().get(2));
    }

    @Test
    void sortServersByEnergyConsumptionMethod_Test() {
        Server server3 = new Server(150.0);
        dataCenter.addServer(server3);
        server1.setLoad(50.0);
        server2.setLoad(100.0);
        server3.setLoad(75.0);

        dataCenter.sortServersByEnergyConsumption();

        assertEquals(server1, dataCenter.getServers().get(0));
        assertEquals(server3, dataCenter.getServers().get(1));
        assertEquals(server2, dataCenter.getServers().get(2));
    }

    @Test
    void setServersLoadToZeroMethod_Test() {
        server1.setLoad(50.0);
        server2.setLoad(100.0);

        dataCenter.setServersLoadToZero();

        assertEquals(0.0, server1.getLoad());
        assertEquals(0.0, server2.getLoad());
    }
}
