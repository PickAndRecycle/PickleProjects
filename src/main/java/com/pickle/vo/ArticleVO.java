package com.pickle.vo;


/**
 * Created by kamar on 3/11/2015.
 */
public class ArticleVO extends BaseVO {
    private String title;
    private String photo_url;
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
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
        sb.append("title='").append(title).append('\'');
        sb.append(", photo_url='").append(photo_url).append('\'');
        sb.append(", content=").append(content).append('\'');
        return sb.toString();
    }


}
