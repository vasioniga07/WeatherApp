package ro.mta.se.lab.model;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class  ForecastGetter {
    private static ForecastGetter getterInstance = null;

    private static String appID="75d4823f6bec3a385f7d4e93e55bdbd3";
    private  JSONObject jsonObject;


    private ForecastGetter()
    {

    }

    public  static  ForecastGetter get_instance()
    {
        if (getterInstance == null)
            getterInstance=new ForecastGetter();

        return getterInstance;
    }


    public  Forecast request_data(Location _location) {

        BufferedReader reader;

        HttpURLConnection connection = null;
        String line;
        StringBuffer responseContent=new StringBuffer();

       try
        {
            int cityID=  _location.getIdLocation();
            URL url= new URL("http://api.openweathermap.org/data/2.5/weather?id="+cityID+"&appid="+appID+"&units=imperial");
            connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(7000); connection.setReadTimeout(7000);
            int status=connection.getResponseCode();
            if(status>299)
            {
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line=reader.readLine())!=null)
                {
                    responseContent.append(line);
                }

                reader.close();
            }
            else
            {
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line=reader.readLine())!=null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }

            String jsonString =responseContent.toString() ; //assign your JSON String here
            this.jsonObject = new JSONObject(jsonString);

        }
        catch (MalformedURLException e) {
                e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
           connection.disconnect();
       }

        if(this.jsonObject!=null)
        {
            Forecast myForescast=build_forecast();
            if(myForescast!=null)
            {
            return myForescast;
            }
        }
        else
        {
            System.out.println("JSON null");
        }











        return  null;
    }

    public  Forecast build_forecast()
    {



        double wind=this.jsonObject.getJSONObject("wind").getDouble("speed");
        double humidity = this.jsonObject.getJSONObject("main").getDouble("humidity");
        double temperature=this.jsonObject.getJSONObject("main").getDouble("temp");
        String rainfallMain=this.jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
        String rainfallDesc=this.jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        long timeForecast=this.jsonObject.getLong("dt");
        System.out.println(timeForecast);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(timeForecast*1000);
        String forecastTime=formatter.format(date);
        String icon=this.jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");

        Forecast to_return=new Forecast(temperature,wind,rainfallMain,rainfallDesc,forecastTime,humidity,icon);

        return  to_return;


    }

}
