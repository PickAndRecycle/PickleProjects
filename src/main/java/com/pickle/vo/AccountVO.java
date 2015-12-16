package com.pickle.vo;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by danieldeem on 11/2/2015.
 */
public class AccountVO extends BaseVO {

    private String username;
    private String email;
    private String password;
    private String phone_number;
    private Boolean google;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public Boolean getGoogle() { return google; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGoogle(Boolean google) { this.google = google;}

    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("username='").append(getUsername()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", password=").append(getPassword());
        sb.append(", phone number='").append(getPhone_number()).append('\'');
        sb.append(", google='").append(getPhone_number()).append('\'');
        return sb.toString();
    }
}
