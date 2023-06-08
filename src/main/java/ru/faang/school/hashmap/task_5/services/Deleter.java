package ru.faang.school.hashmap.task_5.services;

import ru.faang.school.hashmap.task_5.WebPage;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Deleter {
    public static void deletePage(String url, Map<String, LinkedList<WebPage>> hash) {
        for (LinkedList<WebPage> pages : hash.values()) {
            for (WebPage page : pages) {
                if (Objects.equals(url, page.getUrl())) {
                    pages.remove(page);
                    break;
                }
            }
        }
        hash.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }
}

