package ro.mta.se.lab.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import ro.mta.se.lab.model.ForecastGetter;

import java.io.IOException;
import java.net.URL;

public class MainTest extends Application {


    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(this.getClass().getResource("/view/ForecastViewTest.fxml"));
        primaryStage.setScene(new Scene(loader.load()));

        primaryStage.show();


    }
}