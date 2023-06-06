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

    public void addServer(Server server){
        servers.add(server);
    }

    public void removeServer(Server server){
        servers.remove(server);
    }
}
