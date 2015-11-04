package com.pickle.vo;

import com.pickle.enums.TrashCategories;
import com.pickle.enums.UnusedCondition;
import com.pickle.persistence.domain.Trash;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */
public class TrashVO extends BaseVO {

    private String categories;
    private String username;
    private int status;
    private String description;
    private int distance;
    private String photo_url;
    private double latitude;
    private double longitude;
    private boolean report;
    private String title;
    private String condition;
    private int size;

    public TrashCategories getCategories(){
        return TrashCategories.valueOf(categories);
    }

    public void setCategories(TrashCategories categories){
        this.categories = categories.toString();
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getDistance(){
        return distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public String getPhoto_url(){
        return photo_url;
    }

    public void setPhoto_url(String photo_url){
        this.photo_url = photo_url;
    }

    public Double getLatitude(){
        return latitude;
    }

    public void setLatitude(int latitude){
        this.latitude = latitude;
    }

    public Double getLongitude(){
        return longitude;
    }

    public void setLongitude(int longitude){
        this.longitude = longitude;
    }

    public boolean getReport(){
        return report;
    }

    public void setReport(boolean report){
        this.report = report;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public UnusedCondition getCondition(){
        return UnusedCondition.valueOf(condition);
    }

    public void setCondition(UnusedCondition condition){
        this.condition = condition.toString();
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trash{");
        sb.append("categories='").append(getCategories()).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", status=").append(status);
        sb.append(", description='").append(description).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(", photo url='").append(photo_url).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", title='").append(title).append('\'');
        sb.append(", condition='").append(getCondition()).append('\'');
        sb.append(", size='").append(size);
        return sb.toString();
    }
}
