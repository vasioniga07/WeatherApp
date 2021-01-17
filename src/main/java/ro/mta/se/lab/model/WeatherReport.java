package ro.mta.se.lab.model;

/**
 *  Funcția WeatherReport are rolul de a realiza
 *  o legătura între clasele Forecast și Location.
 *  Aceasta se folosește de clasa ForecastGetter pentru
 *  obținerea datelor.
 *
 */




public class
WeatherReport {
    /**
     * Obiectul location reprezintă locația pentru care solicităm datele
     * meteorologice.
     * forecast reprezintă datele meteorologice  aferente
     * obiectului location.
     *
     *
     */

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
        this.forecastGetter=ForecastGetter.get_instance();
        this.forecast=this.forecastGetter.request_data(this.location);

    }



}
