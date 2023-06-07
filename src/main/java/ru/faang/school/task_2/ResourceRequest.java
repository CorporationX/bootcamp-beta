package ru.faang.school.task_2;

import lombok.Getter;

@Getter
public class ResourceRequest {

    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }
}
