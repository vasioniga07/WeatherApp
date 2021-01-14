package ro.mta.se.lab.test.model;

import org.junit.Test;
import ro.mta.se.lab.model.Forecast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ForecastTest {
    @Test
    public  void test_forecast()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Forecast forecast1=new Forecast(26.6,-5.0,"sunny","warm",formatter.format(date),90,"01d");
        assertEquals(-5.0,forecast1.getWind(),0.001);
        assertEquals("sunny",forecast1.getRainfallMain());
        assertEquals("warm",forecast1.getRainfallDesc());
        assertEquals(90.0,forecast1.getHumidity(),0.001);
        assertEquals(-3,forecast1.getTemperatureC(),0.001);
        assertEquals(26.6,forecast1.getTemperatureF(),0.001);

    }

}
