package ma.hmzelidrissi.presentation;

import ma.hmzelidrissi.model.Weather;

public class WeatherPresImpl implements WeatherPres {
    @Override
    public void displayWeather(Weather weather) {
        System.out.println("Temperature: " + weather.getTemperature() + "°C");
        System.out.println("Description: " + weather.getDescription());
    }
}
