package ru.faang.school.hashmap.task_4;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, WeatherData> WEATHER_CACHE;

    static {
        WEATHER_CACHE = new HashMap<>();
    }

    public static void main(String[] args) {
        updateWeather("Moscow", 25.0, 60.0);
        updateWeather("London", 20.0, 70.0);
        updateWeather("New York", 30.0, 50.0);

        printAllCities();

        WeatherData moscowWeather = getWeather("Moscow");
        System.out.println("Temperature in Moscow: " + moscowWeather.temperature());
        System.out.println("Humidity in Moscow: " + moscowWeather.humidity());

        removeWeather("London");
        printAllCities();

    }

    public static WeatherData getWeather(String city) {
        WeatherData weatherData = WEATHER_CACHE.get(city);

        if (weatherData != null) {
            return weatherData; // Weather information for the city is already in the cache
        } else {
            weatherData = WeatherService.getWeatherData(city);
            if (weatherData != null) {
                WEATHER_CACHE.put(city, weatherData); // Save weather information to the cache
            }
            return weatherData;
        }
    }

    public static void updateWeather(String city, double temperature, double humidity) {
        WeatherData updatedWeatherData = new WeatherData(city, temperature, humidity);
        WEATHER_CACHE.put(city, updatedWeatherData);
    }

    public static void removeWeather(String city) {
        WEATHER_CACHE.remove(city);
    }

    public static void printAllCities() {
        WEATHER_CACHE.keySet().forEach(System.out::println);
    }
}
