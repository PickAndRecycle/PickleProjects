package com.pickle.vo;

/**
 * Created by danieldeem on 11/2/2015.
 */
public class AccountVO extends BaseVO {

    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String profilePictureURL;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("username='").append(getUsername()).append('\'');
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", password=").append(getPassword());
        sb.append(", phone number='").append(getPhoneNumber()).append('\'');
        sb.append(", profile picture URL='").append(getProfilePictureURL());
        return sb.toString();
    }
}
