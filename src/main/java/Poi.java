
public class Poi {
    private String id;
    private double lon;
    private double lat;

    public Poi(String id, String lat, String lon) {
        this.id = id;
        this.lat = Double.parseDouble(lat);
        this.lon = Double.parseDouble(lon);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
