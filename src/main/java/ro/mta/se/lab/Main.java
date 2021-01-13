package ro.mta.se.lab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import ro.mta.se.lab.model.ForecastGetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getResource("/view/ForecastView.fxml"));
        primaryStage.setScene(new Scene(loader.load()));

        primaryStage.show();










    }
}