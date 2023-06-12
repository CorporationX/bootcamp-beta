package ru.faang.school.hashmap.task_4.weatherData;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        checkWeatherData(city, temperature, humidity);
    }

    private void checkWeatherData(String city, int temperature, int humidity) {
        if (city != null && (temperature > -80 && temperature < 80) && (humidity > 0 && humidity < 100)) {
            this.city = city;
            this.temperature = temperature;
            this.humidity = humidity;
        } else {
            throw new IllegalArgumentException("температура должна быть не ниже 80 и выше 80");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity=" + humidity +
                '}';
    }
}
