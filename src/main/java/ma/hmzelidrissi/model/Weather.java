package ma.hmzelidrissi.model;

public class Weather {
    private float temperature;
    private String description;
    public Weather(float temperature, String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
