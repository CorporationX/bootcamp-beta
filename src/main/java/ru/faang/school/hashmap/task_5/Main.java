package ru.faang.school.hashmap.task_5;

import ru.faang.school.hashmap.task_5.webPage.WebPage;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> mapContents = new HashMap<>();

    public static void main(String[] args) {
        mapContents.put("Пока", new ArrayList<>());
        mapContents.put("быть", new ArrayList<>());
        mapContents.put("ракета", new ArrayList<>());

        addWebPageInList(new WebPage("rrr", "port", lineFeedTo("Пока мы живы — можно все исправить,\n" +
                "Пока возможно — полной грудью жить.\n" +
                "Тех, кто не нужен, позади оставить.\n" +
                "Кого не-до-любили — долюбить…")));
        addWebPageInList(new WebPage("rrr", "port", lineFeedTo("Красивым быть — не значит им родиться,\n" +
                "Ведь красоте мы можем научиться.\n" +
                "Когда красив душою Человек —\n" +
                "Какая внешность может с ней сравниться?")));
        addWebPageInList(new WebPage("rrr", "port", lineFeedTo("Когда замрут отчаянье и злоба,\n" +
                "Нисходит сон. И крепко спим мы оба\n" +
                "На разных полюсах земли.\n" +
                "\n" +
                "Ты обо мне, быть может, грезишь в эти\n" +
                "Часы. Идут часы походкою столетий,\n" +
                "И сны встают в земной дали.")));
        addWebPageInList(new WebPage("rrr", "port", lineFeedTo("Достигая желаемой высоты,\n" +
                "Очень трудно быть собранным…На бегу,\n" +
                "Перед тем, как поджечь за собой мосты,\n" +
                "Убедись, а на том ли ты берегу.")));

        searchList("Пока");
        searchList("быть");
        searchList("ракета");

    }

    private static String lineFeedTo(String content) {
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private static void addWebPageInList(WebPage webPage) {
        String[] arrContent = webPage.getContent().split(" ", 0);
        List<String> index = new ArrayList<>(50);
        for (int i = 0; i < arrContent.length; i++) {
            if (mapContents.containsKey(arrContent[i]) & !index.contains(arrContent[i])) {
                index.add(arrContent[i]);
                mapContents.get(arrContent[i]).add(webPage);
            }
        }
    }

    private static void searchList(String key) {
        Optional<List<WebPage>> list = searchOptional(key);
        if (list.isPresent()) {
            list.get().forEach(webPage -> System.out.println(key + ": \n" + webPage.getContent() + "_______________\n"));
        } else {
            System.out.printf("Лист %s пуст !!!", key);
        }
    }

    private static Optional<List<WebPage>> searchOptional(String key) {
        if (mapContents.containsKey(key) & !mapContents.get(key).isEmpty()) {
            return Optional.of(mapContents.get(key));
        }
        return Optional.empty();
    }
}
