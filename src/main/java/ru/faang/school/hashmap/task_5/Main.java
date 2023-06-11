package ru.faang.school.hashmap.task_5;

import ru.faang.school.hashmap.task_5.webPage.WebPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, List<WebPage>> mapContents = new HashMap<>();

    public static void main(String[] args) {
        mapContents.put("функции", new ArrayList<>());
        mapContents.put("создает", new ArrayList<>());
        mapContents.put("факториала", new ArrayList<>());

        addWebPageInList(new WebPage("qqq", "tns", "Рекурсивные тоже создает используют стек вызовов! Посмотрим, как это делается, на примере функции вычисления факториала. Вызов factorial(5) записывается в виде 5! и определяется следующим образом: 5! = 5*4*3*2*1. По тому же принципу factorial(3) соответствует 3*2*1. Рекурсивная создает функции функция для вычисления факториала числа выглядит так:"));

        addWebPageInList(new WebPage("rrr", "pimp", "Реализуйте метод для индексирования новой веб-страницы, который будет принимать объект класса WebPage и добавлять его в индекс. Метод должен разбивать содержание страницы н к переменной x, принадлежащей другой функции невозможно"));

        try {
//            searchKey("функции").forEach(webPage -> System.out.println(webPage.getContent()));
            searchKey("создает").forEach(webPage -> System.out.println(webPage.getContent()));
//            searchKey("факториала").forEach(webPage -> System.out.println(webPage.getContent()));
        } catch (NullPointerException e) {
            e.getMessage();
        }

    }

    private static void addWebPageInList(WebPage webPage) {
        String[] arrContent = webPage.getContent().split(" ", 0);
        for (int i = 0; i < arrContent.length; i++) {
            Map<WebPage, String> webPageMap = new HashMap();
            if (mapContents.containsKey(arrContent[i])) {
                webPageMap.put(webPage, null);
                if (!webPageMap.containsKey(webPage)) {
                    mapContents.get(arrContent[i]).add(webPage);
                }
            }
        }
    }

    private static List<WebPage> searchKey(String key) {
        if (mapContents.containsKey(key)) {
            return mapContents.get(key);
        }
        throw new NullPointerException("list null !!!");
    }
}
