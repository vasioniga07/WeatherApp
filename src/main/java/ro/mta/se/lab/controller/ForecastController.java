package ro.mta.se.lab.controller;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import ro.mta.se.lab.model.Forecast;
import ro.mta.se.lab.model.Location;
import ro.mta.se.lab.model.Logger;
import ro.mta.se.lab.model.WeatherReport;
import javafx.scene.image.ImageView;
import java.io.*;
import java.util.ArrayList;

public class ForecastController {



    @FXML
    private Button weatherButton;

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
    private Label timeLabel;

    @FXML
    private Label weatherLabel;

    @FXML
    private Label weatherDescLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label windLabel;

    @FXML
    private ImageView myicon;


    private ObservableList<String> observableLocations;


    private ArrayList<Location> locations;

    private WeatherReport weatherReport;

    public  void load_file()
    {

        locations=new ArrayList<Location>();

        File file = new File(fileBar.getText());
        Logger logger=Logger.getLoggerInstance();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            alertLabel.setText("Alert:File doesn't exist or could not be open!");
            try {
                logger.log_event("log.txt","Error { The City file couldn't be opened }");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

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
            alertLabel.setText("Alert: File could not be read!");
            try {
                logger.log_event("log.txt","Error { The City file couldn't be read }");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        try {
            logger.log_event("log.txt",(index-1)+" cities loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.alertLabel.setText("Info:");
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
        if(cityBox.getSelectionModel().getSelectedItem()==null)
        {
            return  null;
        }

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

            this.weatherReport = new WeatherReport();
            Location location1 = this.get_current_location();
            if(location1==null)
            {
                alertLabel.setText("Info:Select city");
                return;
            }
            else
            {
                alertLabel.setText("Info:");
            }
            this.weatherReport.setLocation(location1);
            this.weatherReport.retrieveForecast(location1);
            Forecast forecast1 = this.weatherReport.getForecast();

            this.cityLabel.setText("City: "+location1.get_name()+" Country: "+location1.getCountryCode());
            this.timeLabel.setText("Time: "+forecast1.getForecastTime());
            this.weatherLabel.setText("Rainfall: "+forecast1.getRainfallMain());
            this.weatherDescLabel.setText("Rainfall Description: "+forecast1.getRainfallDesc());
            this.humidityLabel.setText("Humidity: "+String.valueOf(forecast1.getHumidity())+"%");
            this.windLabel.setText("Wind: "+String.valueOf(forecast1.getWind())+"km/h");

            Logger logger=Logger.getLoggerInstance();
        try {
            logger.log_event("log.txt","Succes interogation {City: "+location1.get_name()+" Country: "+location1.getCountryCode()
            +"Rainfall: "+forecast1.getRainfallMain()+"Rainfall Description: "+forecast1.getRainfallDesc()+
                    "Humidity: "+String.valueOf(forecast1.getHumidity())+"%"+ "Wind: "+String.valueOf(forecast1.getWind())+"km/h}");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("./src/main/resources/images/"+forecast1.getIcon()+".png");
        Image image = new Image(file.toURI().toString());
        this.myicon.setImage(image);





    }




}
