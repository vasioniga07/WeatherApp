package ro.mta.se.lab.test.controllerTest;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ro.mta.se.lab.model.Forecast;
import ro.mta.se.lab.model.Location;
import  ro.mta.se.lab.test.model.WeatherReportTest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ForecastControllerTest {





    @FXML
    private Button loadFileButton;

    @FXML
    private Label alertLabel;

    @FXML
    private  ComboBox countryBox;

    @FXML
    private  ComboBox cityBox;

    @FXML
    private TextField fileBar;

    @FXML
    private Label cityLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label rainfallLabel;

    @FXML
    private Label rainfallDescLabel;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label windLabel;


    private ObservableList<String> observableLocations;


    private ArrayList<Location> locations;

    private WeatherReportTest weatherReport;

    public  void load_file()
    {

        locations=new ArrayList<Location>();

        File file = new File(fileBar.getText());


        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            alertLabel.setText("Alert:File doesn't exist or could not be open!");
            e.printStackTrace();
        }

        String st;
        int index=0;
        try {
            while ((st = br.readLine()) != null) {
                String aux[]=st.split(" ");

                if(index>0)
                {
                    int idLoc=Integer.parseInt(aux[0]); float latLoc=Float.parseFloat(aux[2]);
                    String numeLoc=aux[1]; float longLoc=Float.parseFloat(aux[3]);
                    String countryLoc=aux[4];
                    locations.add(new Location(idLoc,numeLoc,latLoc,longLoc,countryLoc));

                    if(countryBox.getItems().contains(aux[4])==false)
                        countryBox.getItems().add(aux[4]);

                }
                index++;
            }
        }catch (Exception e) {
            e.printStackTrace();
            alertLabel.setText("Alert: Could not be read!");
        }
    }

    public  void load_cities()
    {
        cityBox.getItems().clear();
        for(int i=0;i<locations.size();i++)
        {
            Location aux=locations.get(i);

            String name=aux.get_name();

            if(countryBox.getSelectionModel().getSelectedItem().equals(aux.getCountryCode()))
            {
                if(cityBox.getItems().contains(name)==false)
                    cityBox.getItems().add(aux.get_name());

            }
        }

    }

    public Location get_current_location()
    {
        Location aux_loc;

        for(int i=0;i<locations.size();i++)
        {
            if(locations.get(i).get_name().equals(cityBox.getSelectionModel().getSelectedItem().toString()))
            {
                aux_loc=locations.get(i);
                return  aux_loc;
            }
        }

        return  null;
    }

    public  void showWeather()
    {
        this.weatherReport=new WeatherReportTest();
        try {
            this.weatherReport.setUp();
            this.weatherReport.retrieveForecast();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Forecast AuxForecast=this.weatherReport.getForecast();
        this.cityLabel.setText("TestCity");
        this.dateLabel.setText(AuxForecast.getForecastTime());
        this.rainfallLabel.setText(AuxForecast.getRainfallMain());
        this.rainfallDescLabel.setText(AuxForecast.getRainfallDesc());
        this.temperatureLabel.setText(String.valueOf(AuxForecast.getTemperatureF()+" F"));
        this.windLabel.setText(String.valueOf(AuxForecast.getWind()));
        this.humidityLabel.setText(String.valueOf(AuxForecast.getHumidity())+"%");


    }




}
