package com.pickle.service.impl;


import com.pickle.persistence.domain.Trash;
import com.pickle.service.TrashService;
import com.pickle.vo.TrashVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class TrashServiceImplTest {

    @Autowired
    private TrashService trashService;

    @Test
    public void testAdd() throws Exception {

        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setThumbnailUrl("");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setDistance(10);
        trashVO.setLatitude(20);
        trashVO.setLongitude(20);
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        TrashVO resultVo = trashService.add(trashVO);

        assertEquals(trashVO.getId(),resultVo.getId());

    }

    @Test
    public void testFindById() throws Exception {
        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setThumbnailUrl("");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setDistance(10);
        trashVO.setLatitude(20);
        trashVO.setLongitude(20);
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        TrashVO tempVo = trashService.add(trashVO);
        TrashVO resultVO = trashService.findById(tempVo.getId());

        assertEquals(resultVO.getId(),tempVo.getId());
    }

    @Test
    public void testUpdate() throws Exception {

        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setThumbnailUrl("");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setDistance(10);
        trashVO.setLatitude(20);
        trashVO.setLongitude(20);
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        TrashVO tempVo = trashService.add(trashVO);

        trashVO.setDescription("New Description");


        TrashVO resultVO = trashService.update(tempVo.getId(), trashVO);

        assertEquals(resultVO.getDescription(),"New Description");
    }

    @Test
    public void testFindAll() throws Exception {

        TrashVO trashVO = new TrashVO();
        trashVO.setThumbnailUrl("");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDistance(10);
        trashVO.setLatitude(20);
        trashVO.setLongitude(20);
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);
        trashVO.setId("234");
        trashVO.setUsername("Daniel");
        trashVO.setDescription("New Description");

        TrashVO tempVo = trashService.add(trashVO);

        Collection<TrashVO> collection = trashService.findAll();

        System.out.print(collection.toString());

        assertEquals(2,collection.size());
    }





}