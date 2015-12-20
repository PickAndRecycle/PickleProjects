package com.pickle.service.impl;

import com.pickle.service.ArticleService;
import com.pickle.vo.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by tsabitacyavrilla on 12/20/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")

public class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testAdd() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setTitle("New Article About Trash");
        articleVO.setPhoto_url("http://104.155.237.238/pic/trashImages/26399500_WO-AV462_OCEANS_9U_20150212130916.jpg");
        articleVO.setContent("Lorem ipsum dolor sit amet.");

        ArticleVO resultVO = articleService.add(articleVO);
        assertEquals(articleVO.getTitle(), resultVO.getTitle());
    }

    @Test
    public void testFindById() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId("1");
        articleVO.setTitle("Ways to Manage Trash");
        articleVO.setPhoto_url("http://104.155.237.238/pic/trashImages/26399500_WO-AV462_OCEANS_9U_20150212130916.jpg");
        articleVO.setContent("This is a content of an article.");

        ArticleVO tempVO = articleService.add(articleVO);
        ArticleVO resultVO = articleService.findById(tempVO.getId());

        assertEquals(resultVO.getId(),tempVO.getId());
    }

    @Test
    public void testFindAll() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId("2");
        articleVO.setTitle("Waste Management System");
        articleVO.setPhoto_url("http://104.155.237.238/pic/trashImages/26399500_WO-AV462_OCEANS_9U_20150212130916.jpg");
        articleVO.setContent("This is a content of an article.");

        ArticleVO tempVO = articleService.add(articleVO);
        Collection<ArticleVO> collection = articleService.findAll();
        System.out.print(collection.toString());

        assertEquals(2,collection.size());
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId("12");
        articleVO.setTitle("Waste Management System");
        articleVO.setPhoto_url("http://104.155.237.238/pic/trashImages/26399500_WO-AV462_OCEANS_9U_20150212130916.jpg");
        articleVO.setContent("This is a content of an article.");

        ArticleVO tempVO = articleService.add(articleVO);
        articleVO.setContent("Lorem ipsum dolor sit amet.");
        ArticleVO resultVO = articleService.update(tempVO.getId(), articleVO);
        assertEquals(resultVO.getContent(), "Lorem ipsum dolor sit amet.");
    }

}
