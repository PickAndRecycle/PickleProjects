package com.pickle.persistence.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * Created by admin on 11/2/2015.
 */



@Entity
@Table(name= "ACCOUNT")
@DynamicUpdate
public class Account extends Base {
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD", length = 1500)
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phone_number;
    @Column(name = "GOOGLE")
    private Boolean google;

    @PrePersist
    public void prePersist(){
        super.prePersist();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Boolean getGoogle() {
        return google;
    }

    public void setGoogle(Boolean google) {
        this.google = google;
    }



    public String toString(){
        StringBuffer sb = new StringBuffer("Account{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone number='").append(phone_number).append('\'');
        sb.append(", google='").append(google).append('\'');
        return sb.toString();
    }
}
