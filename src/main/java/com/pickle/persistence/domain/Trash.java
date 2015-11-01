package com.pickle.persistence.domain;

import com.pickle.enums.TrashCategories;
import com.pickle.enums.UnusedCondition;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.net.URL;
import java.security.SecureRandom;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */

@Entity
@Table(name= "TRASH")
@DynamicUpdate
public class Trash extends Base {

    @Column(name = "CATEGORIES")
    private TrashCategories categories;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "DISTANCE")
    private int distance;

    @Column(name = "PHOTO_URL")
    private String photo_url;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "REPORT")
    private boolean report;

    @Column(name = "TITLE", length = 30)
    private String title;

    @Column(name = "CONDITION")
    private UnusedCondition condition;

    @Column(name = "SIZE")
    private int size;

    @PrePersist
    public void prePersist(){
        super.prePersist();
    }

    public String getCategories(){
        return categories.toString();
    }

    public void setCategories(String categories){
        TrashCategories categories1 = TrashCategories.valueOf(categories);
        this.categories = categories1;
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

    public String getCondition(){
        return condition.toString();
    }

    public void setCondition(String condition){
        UnusedCondition condition1 = UnusedCondition.valueOf(condition);
        this.condition = condition1;
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
