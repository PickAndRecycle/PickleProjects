package com.pickle.vo;

/**
 * Created by danieldeem on 11/2/2015.
 */
public class AccountVO {

    private String username;
    private String email;
    private String password;
    private String phone_number;
    private String profile_picture_url;

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

    public String getProfile_picture_url() {
        return profile_picture_url;
    }

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

    public void setProfile_picture_url(String profile_picture_url) {
        this.profile_picture_url = profile_picture_url;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("username='").append(getUsername()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", password=").append(getPassword());
        sb.append(", phone number='").append(getPhone_number()).append('\'');
        sb.append(", profile picture=").append(getProfile_picture_url());
        return sb.toString();
    }
}
