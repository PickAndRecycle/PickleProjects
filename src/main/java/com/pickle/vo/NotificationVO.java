package com.pickle.vo;

/**
 * Created by Yanuar Wicaksana on 12/2/15.
 */
public class NotificationVO extends BaseVO{

    private String token;
    private String username;

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
