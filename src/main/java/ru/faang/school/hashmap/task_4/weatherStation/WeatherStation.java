package ru.faang.school.hashmap.task_4.weatherStation;

import ru.faang.school.hashmap.task_4.weatherData.WeatherData;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherStation {
    public WeatherData getWeatherStation(String city) {
        int temperature = ThreadLocalRandom.current().nextInt(-80, 80);
        int humidity = ThreadLocalRandom.current().nextInt(0, 100);
        return new WeatherData(city, temperature, humidity);
    }
}
