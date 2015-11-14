package com.pickle.persistence.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Created by Yanuar Wicaksana on 11/13/15.
 */

@Entity
@Table(name= "ARTICLE")
@DynamicUpdate
public class Article extends Base {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PHOTO_URL")
    private String photo_url;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photoUrl) {
        this.photo_url = photo_url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("title='").append(title).append('\'');
        sb.append(", photoUrl='").append(photo_url).append('\'');
        sb.append(", content=").append(content).append('\'');
        return sb.toString();
    }
}
