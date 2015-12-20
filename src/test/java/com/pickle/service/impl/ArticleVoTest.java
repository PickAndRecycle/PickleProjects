package com.pickle.service.impl;

/**
 * Created by tsabitacyavrilla on 12/20/15.
 */

import com.pickle.vo.ArticleVO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleVoTest {

    @Test
    public void testTitle() throws Exception {
        ArticleVO article = new ArticleVO();
        String title = "Tips On Waste Management";
        article.setTitle(title);
        assertEquals(title, article.getTitle());
    }

    @Test
    public void testContent() throws Exception {
        ArticleVO article = new ArticleVO();
        String content = "Lorem ipsum dolor sit amet.";
        article.setContent(content);
        assertEquals(content, article.getContent());
    }
}
