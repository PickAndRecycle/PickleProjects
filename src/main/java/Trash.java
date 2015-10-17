/**
 * Created by Yanuar Wicaksana on 10/15/15.
 */


import java.io.File;
import java.sql.Time;
import java.util.*;


public class Trash {
    private int id, status;
    private String description;
    private File photo;
    private Double latitude,longitude;
    private Time timestamp;
    private boolean report;




    public Trash(int id, String description, int status, File photo, Double latitude, Double longitude, Time timestamp, boolean report){
        this.id = id;
        this.description = description;
        this.status = status;
        this.photo = photo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
        this.report = report;
    }

    public void test(){
        System.out.println("test");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Time getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Time timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public int CalculateDist(Double lon, Double lat){
        return -1;
    }
}
