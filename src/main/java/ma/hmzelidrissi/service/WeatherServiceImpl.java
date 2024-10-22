package ma.hmzelidrissi.service;

import ma.hmzelidrissi.model.Weather;

public class WeatherServiceImpl implements WeatherService {
    @Override
    public Weather getWeather() {
        return new Weather(25.0f, "Sunny");
    }
}
