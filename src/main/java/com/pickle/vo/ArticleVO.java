package com.pickle.vo;


/**
 * Created by kamar on 3/11/2015.
 */
public class ArticleVO extends BaseVO {
    private String username;
    private String title;
    private String photo_data; //TODO: Photo data in base64 format.
    private String content;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("username='").append(username).append('\'');
        sb.append(", title='").append(title);
        sb.append(", photo_data='").append(photo_data).append('\'');
        sb.append(", content='").append(content);
        return sb.toString();
    }


}
