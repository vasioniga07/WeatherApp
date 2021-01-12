package ro.mta.se.lab.model;

public class Location {
    private int idLocation;
    private String Name;
    private double latitude;
    private  double longitude;
    private  String countryCode;

    public Location(int idLocation,
                    String name,
                    double latitude,
                    double longitude,
                    String countryCode) {
        this.idLocation = idLocation;
        this.Name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.countryCode = countryCode;
    }

    public String get_name()
    {
        return this.Name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}
