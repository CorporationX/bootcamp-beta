package ru.faang.school.hashmap.task_4;

public class WeatherService {
    /**
     * Stub method for getting weather information from an external source
     * In reality, this will be an implementation of a request to an external service
     * For the example, I returned dummy values
     * @param city
     * @return WeatherData
     */
    public static WeatherData getWeatherData(String city) {

        switch (city) {
            case "Moscow" -> {
                return new WeatherData(city,25.0,60.0);
            }
            case "London" -> {
                return new WeatherData(city, 20.0,70.0);
            }
            case "New York" -> {
                return new WeatherData(city, 30.0,50.0);
            }
            default -> {
                return null;
            }
        }
    }
}
