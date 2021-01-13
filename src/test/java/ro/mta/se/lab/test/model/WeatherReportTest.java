package ro.mta.se.lab.test.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import ro.mta.se.lab.model.Forecast;
import ro.mta.se.lab.model.ForecastGetter;
import ro.mta.se.lab.model.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherReportTest {


    private Forecast forecast;
    private Location location;

    @Spy
    public  ForecastGetter mockFG;

    public Forecast getForecast() {
        return this.forecast;
    }

    @Before
    public void setUp() throws Exception {
        mockFG = mock(ForecastGetter.class);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        when(mockFG.request_data(any())).thenReturn(
                new Forecast(77,5.0,"sunny","warm",formatter.format(date),90));

    }


    @Test
    public  void verify_weather()
    {

        Forecast forecast1=mockFG.request_data(any());

        assertEquals(5.0,forecast1.getWind(),0.001);
        assertEquals("sunny",forecast1.getRainfallMain());
        assertEquals("warm",forecast1.getRainfallDesc());
        assertEquals(90.0,forecast1.getHumidity(),0.001);
        assertEquals(25.0,forecast1.getTemperatureC(),0.001);
        assertEquals(77,forecast1.getTemperatureF(),0.001);
        verify(mockFG).request_data(any());
        verify(mockFG,times(1)).request_data(any());


    }

    public  void  retrieveForecast()
    {
        this.forecast=this.mockFG.request_data(any());
    }












}
