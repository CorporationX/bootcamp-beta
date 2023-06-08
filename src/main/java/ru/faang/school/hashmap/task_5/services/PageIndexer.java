package ru.faang.school.hashmap.task_5.services;

import ru.faang.school.hashmap.task_5.WebPage;

import java.util.LinkedList;
import java.util.Map;

public class PageIndexer {
    public static void addPage(WebPage page, Map<String, LinkedList<WebPage>> hash) {
        for (String word : page.getWords()) {
            if (hash.containsKey(word)) {
                hash.get(word).add(page);
            } else {
                LinkedList<WebPage> storage = new LinkedList<>();
                storage.add(page);
                hash.put(word, storage);
            }

        }

    }
}
