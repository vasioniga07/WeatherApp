package ro.mta.se.lab.model;

public class Forecast {

private double temperatureF;
private  double temperatureC;
private  double wind;
private  double humidity;
private  String rainfallMain;
private  String rainfallDesc;
private  String forecastTime;
private  String image;

    public  double convert_temp(double tempF)
    {
        double tempC=(tempF-32)/(1.8);
        return  tempC;
    }

    public String getForecastTime() {
        return forecastTime;
    }

    public Forecast(double temperatureF, double wind, String rainfallMain, String rainfallDesc, String _forecastTime, double _humidity,String _image) {
        this.temperatureF = temperatureF;
        this.temperatureC=this.convert_temp(temperatureF);
        this.wind = wind;
        this.rainfallMain = rainfallMain;
        this.rainfallDesc = rainfallDesc;
        this.forecastTime = _forecastTime;
        this.humidity=_humidity;
        this.image=_image;
    }

    public String getIcon() {
        return image;
    }

    public double getHumidity() {
        return humidity;
    }
    public double getTemperatureF() {
        return temperatureF;
    }

    public double getTemperatureC() {
        return temperatureC;
    }

    public double getWind() {
        return wind;
    }

    public String getRainfallMain() {
        return rainfallMain;
    }

    public String getRainfallDesc() {
        return rainfallDesc;
    }
}
