package ru.faang.school.hashmap.task_5;

import lombok.Data;

@Data
public class WebPage {
    private String url;
    private String title;
    private String content;

    public String[] getWords() {
        return content.split(" ");
    }
}
