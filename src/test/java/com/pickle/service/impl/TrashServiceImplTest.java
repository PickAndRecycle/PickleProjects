package com.pickle.service.impl;


import com.pickle.persistence.domain.Trash;
import com.pickle.service.AccountService;
import com.pickle.service.NotificationService;
import com.pickle.service.TrashService;
import com.pickle.vo.AccountVO;
import com.pickle.vo.NotificationVO;
import com.pickle.vo.TrashVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class TrashServiceImplTest {

    @Autowired
    private TrashService trashService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private NotificationService notificationService;

    @Test
    public void testAdd() throws Exception {

        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        AccountVO accountVO = accountService.findByName(trashVO.getUsername());
        //int point = accountVO.getPoint();

        TrashVO resultVo = trashService.add(trashVO);

        AccountVO accountVO2 = accountService.findByName(resultVo.getUsername());
        //int nextpoint = accountVO2.getPoint();


        assertEquals(trashVO.getId(), resultVo.getId());
        //assertEquals(point+1,nextpoint);
    }

    @Test
    public void testFindById() throws Exception {
        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
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
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
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
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
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

    @Test
    public void testUpdateWithNotification() throws IOException {
        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        TrashVO tempVo = trashService.add(trashVO);

        NotificationVO notificationVO = new NotificationVO();
        //Put your username and GCM Token here to test it out
        notificationVO.setToken("dijW3UF9Hwg:APA91bG435SaUQ1lNG3HNrmN2IPQb7HaWLkcpkuEXe_CYbIe35tFNb5PezzquoQAZJnsEqhza7SYKqRN7wWJl9QuhxuLSq9ePwi6DYxS8CpP_iiNgWFjFBNe7JZ0K5qboqw-aUWhSTLM");
        notificationVO.setUsername("Yanuar");

        NotificationVO notifVO = notificationService.add(notificationVO);

        notificationVO.setToken("fTpUZosOxnw:APA91bHcHX52XFkTOQZZJX_Fh7608iNZDfxDXMF5VpH_i_BHQJLmfah_xO0C9m6tCpReO1kfB0AB3iCIIjLh_fnrJ2g1lfPJHvGbJW9BVCZmh2CB6j1vQLzmj6U0qIWS1pmvBwjYFNPD");

        NotificationVO notifVO2 = notificationService.add(notificationVO);

        trashVO.setDescription("New Description");

        TrashVO resultVO = trashService.updateWithNotification(tempVo.getId(), trashVO);

        assertEquals(resultVO.getDescription(),"New Description");
    }

    @Test
    public void testDelete(){
        TrashVO trashVO = new TrashVO();
        trashVO.setId("123");
        trashVO.setCategories("Unused Goods");
        trashVO.setTrash_condition("Good");
        trashVO.setUsername("Yanuar");
        trashVO.setTitle("Test Trash");
        trashVO.setStatus(0);
        trashVO.setDescription("Test Description");
        trashVO.setPickerUsername("Tsabita");
        trashVO.setLatitude("20");
        trashVO.setLongitude("20");
        trashVO.setPhoto_url("");
        trashVO.setSize(0);
        trashVO.setReport(false);

        TrashVO tempVo = trashService.add(trashVO);

        boolean result = trashService.delete(tempVo.getId());

        assertEquals(true, result);
    }



}