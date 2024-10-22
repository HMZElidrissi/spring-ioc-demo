package ma.hmzelidrissi;

import ma.hmzelidrissi.model.Weather;
import ma.hmzelidrissi.presentation.WeatherPres;
import ma.hmzelidrissi.service.WeatherService;

public class WeatherApp {
    private WeatherService weatherService;
    private WeatherPres weatherPres;

    public WeatherApp(WeatherService weatherService, WeatherPres weatherPres) {
        this.weatherService = weatherService;
        this.weatherPres = weatherPres;
    }

    public WeatherApp() {
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherPres getWeatherPres() {
        return weatherPres;
    }

    public void setWeatherPres(WeatherPres weatherPres) {
        this.weatherPres = weatherPres;
    }

    public void showWeather() {
        Weather weather = weatherService.getWeather();
        weatherPres.displayWeather(weather);
    }
}
