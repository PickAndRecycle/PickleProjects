package com.pickle.vo;

/**
 * Created by kamar on 10/11/2015.
 */
public class ArticleVO extends BaseVO {
    private String title;
    private String photo_data;
    private String content;

    public String getTitle() {
        return title;
    }

    public String getPhoto_data() {
        return photo_data;
    }

    public String getContent() {return content;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhoto_data(String photo_data) {
        this.photo_data = photo_data;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("title='").append(getTitle()).append('\'');
        sb.append(", photo_data='").append(getPhoto_data()).append('\'');
        sb.append(", content='").append(getContent());
        return sb.toString();
    }
}
