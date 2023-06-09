package ru.faang.school.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataCenterServiceTest {

    private DataCenterService dataCenterService;
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
        dataCenterService = new DataCenterService(dataCenter);
    }

    @Test
    void getTotalEnergyConsumptionMethod_Test() {
        server1.setLoad(20.0);
        server2.setLoad(100.0);
        double actualEnergyConsumption = dataCenterService.getTotalEnergyConsumption();
        double expectedEnergyConsumption = 110.0;

        assertEquals(expectedEnergyConsumption, actualEnergyConsumption);
    }

    @Test
    void removeServerMethod_Test() {
        dataCenterService.removeServer(server2);

        assertEquals(1, dataCenter.getServers().size());
        assertFalse(dataCenter.getServers().contains(server2));
    }

    @Test
    void addServerMethod_Test() {
        Server server3 = new Server(150.0);
        dataCenterService.addServer(server3);

        assertEquals(3, dataCenter.getServers().size());
        assertTrue(dataCenter.getServers().contains(server3));
    }

    @Test
    void allocateResourcesMethod_Test() {
        ResourceRequest request = new ResourceRequest(150.0);

        dataCenterService.allocateResources(request);

        assertEquals(100.0, server1.getLoad());
        assertEquals(50.0, server2.getLoad());
    }

    @Test
    void releaseResourcesMethod_Test() {
        server1.setLoad(100.0);
        server2.setLoad(50.0);
        ResourceRequest request = new ResourceRequest(120.0);

        dataCenterService.releaseResources(request);

        assertEquals(0.0, server1.getLoad());
        assertEquals(30.0, server2.getLoad());
    }

    @Test
    void optimizeMethod_Test() {
        server1.setLoad(50.0);
        server2.setLoad(100.0);

        dataCenterService.optimize(dataCenter);

        assertEquals(100.0, server1.getLoad());
        assertEquals(50.0, server2.getLoad());
        assertEquals(150.0, dataCenter.getTotalServersLoad());
    }
}
