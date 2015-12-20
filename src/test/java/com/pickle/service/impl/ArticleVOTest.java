package com.pickle.service.impl;

/**
 * Created by tsabitacyavrilla on 12/20/15.
 */

import com.pickle.vo.ArticleVO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleVOTest {

    @Test
    public void testTitle() throws Exception {
        ArticleVO article = new ArticleVO();
        String title = "Tips On Waste Management";
        article.setTitle(title);
        assertEquals(title, article.getTitle());
    }

    @Test
    public void testPhotoUrl() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        String photourl = "http://104.155.237.238/pic/trashImages/26399500_WO-AV462_OCEANS_9U_20150212130916.jpg";
        articleVO.setPhoto_url(photourl);
        assertEquals(photourl, articleVO.getPhoto_url());
    }

    @Test
    public void testContent() throws Exception {
        ArticleVO article = new ArticleVO();
        String content = "Lorem ipsum dolor sit amet.";
        article.setContent(content);
        assertEquals(content, article.getContent());
    }

}
