package ro.mta.se.lab.model;

public class
WeatherReport {
    private Forecast forecast;
    private Location location;
    private ForecastGetter forecastGetter;

    public Forecast getForecast() {
        return forecast;
    }



    public Location getLocation() {
        return location;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void setLocation(Location _location) {
        this.location = _location;
    }

    public  void  retrieveForecast(Location location)
    {
        this.forecastGetter=new ForecastGetter();
        this.forecast=this.forecastGetter.request_data(this.location);

    }



}
