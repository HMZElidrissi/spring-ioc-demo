package ma.hmzelidrissi;

import ma.hmzelidrissi.presentation.WeatherPresImpl;
import ma.hmzelidrissi.service.WeatherServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    WeatherApp weatherApp = context.getBean("app", WeatherApp.class);
    weatherApp.showWeather();
  }
}
