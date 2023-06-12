package ru.faang.school.hashmap.task_4;

import ru.faang.school.hashmap.task_4.weatherData.WeatherData;
import ru.faang.school.hashmap.task_4.weatherStation.WeatherStation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final WeatherStation weatherStation = new WeatherStation();
    private static final Map<String, WeatherData> cashWeather = new HashMap<>();

    public static void main(String[] args) {

        getWeatherDataCash("Moscow");
        getWeatherDataCash("Barnaul");
        getWeatherDataCash("Tokio");
        getWeatherDataCash("Amsterdam");
        System.out.println(getWeatherDataCash("Barnaul"));
        System.out.println();
        removeWeatherData("Tokio");
        getAllWeatherData();

    }

    private static WeatherData getWeatherDataCash(String city) {
        if (cashWeather.containsKey(city)) {
            return cashWeather.get(city);
        }
        updateWeatherData(city);
        return cashWeather.get(city);
    }

    private static void updateWeatherData(String city) {
        cashWeather.put(city, weatherStation.getWeatherStation(city));
    }

    private static void removeWeatherData(String city) {
        cashWeather.remove(city);
    }

    private static void getAllWeatherData() {
        cashWeather.forEach((key, value) -> System.out.println(value.toString()));
    }
}
