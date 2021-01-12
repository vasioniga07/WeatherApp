package ro.mta.se.lab.test.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import ro.mta.se.lab.model.Forecast;
import ro.mta.se.lab.model.ForecastGetter;
import ro.mta.se.lab.model.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherReportTest {

    ForecastGetter mockFG;
    private Forecast forecast;
    private Location location;

    public Forecast getForecast() {
        return this.forecast;
    }

    @Before
    public void setUp() throws Exception {
        mockFG = mock(ForecastGetter.class);
        Date date = new Date(); // This object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        when(mockFG.request_data(any())).thenReturn(
                new Forecast(77,5.0,"sunny","warm",formatter.format(date),90));

    }

    @Test

    public  void verify_weather()
    {

        Forecast forecast1=mockFG.request_data(any());
        assertEquals(5.0,forecast1.getWind(),0.001);
        //assertEquals("a","sunny",forecast1.getRainfallMain());

    }

    public  void  retrieveForecast()
    {
        this.forecast=this.mockFG.request_data(any());
    }












}
