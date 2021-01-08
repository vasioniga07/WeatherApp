package ro.mta.se.lab.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ForecastController {
    @FXML
    private ComboBox CountryCombo;
    @FXML
    private ComboBox CityCombo;
    @FXML
    private Button WeatherButton;

    @FXML
    private Label TestLabel;

    @FXML
    private  void showWeather()
    {
       TestLabel.setText("Ana");
    }

}
