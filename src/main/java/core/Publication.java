package core;

public class Publication {
    public final Long timestamp;
    public final Double lat;
    public final Double lon;

    public Publication(Long timestamp, Double lat, Double lon) {
        this.timestamp = timestamp;
        this.lat = lat;
        this.lon = lon;
    }
}
