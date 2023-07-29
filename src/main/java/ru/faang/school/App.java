package ru.faang.school;

import ru.faang.school.hashmap.task_5.WebPage;
import ru.faang.school.hashmap.task_5.services.Deleter;
import ru.faang.school.hashmap.task_5.services.PageIndexer;
import ru.faang.school.hashmap.task_5.services.Searcher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, LinkedList<WebPage>> hash = new HashMap<>();
        WebPage p1 = new WebPage();
        p1.setContent("1 2 3");
        p1.setUrl("1");
        WebPage p2 = new WebPage();
        p2.setContent("3 4 5");
        p2.setUrl("2");
        WebPage p3 = new WebPage();
        p3.setContent("5 6 7");
        p3.setUrl("3");
        PageIndexer.addPage(p1,hash);
        PageIndexer.addPage(p2,hash);
        PageIndexer.addPage(p3,hash);
        System.out.println(hash);
        System.out.println(Searcher.getPages("3",hash));
        Deleter.deletePage("1",hash);
        Deleter.deletePage("2",hash);
        Deleter.deletePage("3",hash);
        Deleter.deletePage("3",hash);
        System.out.println(hash);

    }
}
