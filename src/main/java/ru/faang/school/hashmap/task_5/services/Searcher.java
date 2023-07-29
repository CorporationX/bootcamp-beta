package ru.faang.school.hashmap.task_5.services;

import ru.faang.school.hashmap.task_5.WebPage;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Searcher {
    public static List<WebPage> getPages(String word, Map<String, LinkedList<WebPage>> hash) {
        if (hash.containsKey(word)) {
            return hash.get(word);
        }
        throw new NoSuchElementException("Word not found: " + word);
    }
}
