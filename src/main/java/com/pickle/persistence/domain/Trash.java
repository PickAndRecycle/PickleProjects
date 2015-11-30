package com.pickle.persistence.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;


/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */

@Entity
@Table(name= "TRASH")
@DynamicUpdate
public class Trash extends Base {

    @Column(name = "CATEGORIES")
    private String categories;

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

    @Column(name = "LATITUDE", length = 20)
    private String latitude;

    @Column(name = "LONGITUDE", length = 20)
    private String longitude;

/*
    @Column(name = "LATITUDE", precision = 4, scale = 10)
    private int latitude;

    @Column(name = "LONGITUDE", precision = 4, scale = 10)
    private int longitude;
*/
    @Column(name = "REPORT")
    private boolean report;

    @Column(name = "TITLE", length = 30)
    private String title;

    @Column(name = "TRASH_CONDITION")
    private String trash_condition;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "THUMBNAILURL")
    private String thumbnailUrl;

    @PrePersist
    public void prePersist(){
        super.prePersist();
        this.status = 0;

    }

    public String getCategories(){
        return categories;
    }

    public void setCategories(String categories){
        this.categories = categories;
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

    public String getLatitude(){
        return latitude;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLongitude(){
        return longitude;
    }

    public void setLongitude(String longitude){
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

    public String getTrash_condition(){
        return trash_condition;
    }

    public void setTrash_condition(String trash_condition){
        this.trash_condition = trash_condition;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trash{");
        sb.append("categories='").append(categories).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", status=").append(status);
        sb.append(", description='").append(description).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(", photo url='").append(photo_url).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", report=").append(report);
        sb.append(", title='").append(title).append('\'');
        sb.append(", trash_condition='").append(trash_condition).append('\'');
        sb.append(", size='").append(size);
        sb.append(", thumbnail url='").append(thumbnailUrl).append('\'');
        return sb.toString();
    }
}
