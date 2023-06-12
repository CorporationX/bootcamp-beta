package ru.faang.school.hashmap.task_4;

import ru.faang.school.hashmap.task_4.weatherData.WeatherData;
import ru.faang.school.hashmap.task_4.weatherStation.WeatherStation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final WeatherStation weatherStation = new WeatherStation();
    private static final Map<String, WeatherData> cashWeather = new HashMap<>();

    public static void main(String[] args) {

        getWeather("Moscow");
        getWeather("Barnaul");
        getWeather("Tokio");
        getWeather("Amsterdam");
        System.out.println(getWeather("Barnaul"));
        System.out.println();
        removeWeather("Tokio");
        getAllWeatherData();

    }

    private static WeatherData getWeather(String city) {
        if (cashWeather.containsKey(city)) {
            return cashWeather.get(city);
        } else {
            updateWeather(city);
        }
        return cashWeather.get(city);
    }

    private static void updateWeather(String city) {
        cashWeather.put(city, weatherStation.getWeatherStation(city));
    }

    private static void removeWeather(String city) {
        cashWeather.remove(city);
    }

    private static void getAllWeatherData() {
        cashWeather.forEach((key, value) -> System.out.println(value.toString()));
    }
}
