package ro.mta.se.lab.model;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public interface ForecastGetter {



    public  Forecast request_data(Location location);


    /*HttpClient client=HttpClient.newHttpClient();
    HttpRequest request=HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?id=6911&appid=75d4823f6bec3a385f7d4e93e55bdbd3")).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
                .thenAccept(System.out::println).join();

    */


}
