package com.pickle.persistence.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Created by Yanuar Wicaksana on 12/2/15.
 */

@Entity
@Table(name = "NOTIFICATION")
@DynamicUpdate
public class Notification extends Base {

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "USERNAME")
    private String username;

    @PrePersist
    public void prePersist(){
        super.prePersist();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Notification{");
        sb.append("token='").append(token).append('\'');
        sb.append(", username='").append(username).append('\'');
        return sb.toString();
    }
}
