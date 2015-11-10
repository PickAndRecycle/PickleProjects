package com.pickle.persistence.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Created by kamar on 10/11/2015.
 */

@Entity
@Table(name= "ARTICLE")
@DynamicUpdate
public class Article extends Base {
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PHOTO_DATA")
    private String photo_data;
    @Column(name = "CONTENT")
    private String content;
    @PrePersist
    public void prePersist(){
        super.prePersist();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto_data() {
        return photo_data;
    }

    public void setPhoto_data(String photo_data) {
        this.photo_data = photo_data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("Article{");
        sb.append("title='").append(title).append('\'');
        sb.append(", photo_data='").append(photo_data).append('\'');
        sb.append(", content='").append(content).append('\'');
        return sb.toString();
    }
}
