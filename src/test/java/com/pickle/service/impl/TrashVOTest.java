package com.pickle.service.impl;

import com.pickle.vo.AccountVO;
import com.pickle.vo.TrashVO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hakeem on 11/24/2015.
 */
public class TrashVOTest {
    @Test
    public void testUsername() throws Exception {
        TrashVO trash = new TrashVO();
        String category = "Unused Goods";
        trash.setCategories(category);
        assertEquals(category,trash.getCategories());
    }

    @Test
    public void testEmail() throws Exception {
        TrashVO trash = new TrashVO();
        String username = "hakeemd";
        trash.setUsername(username);
        assertEquals(username,trash.getUsername());
    }

    @Test
    public void testStatus() throws Exception {
        TrashVO trash = new TrashVO();
        int thrown = 0;
        trash.setStatus(0);
        assertEquals(thrown,trash.getStatus());
    }

    @Test
    public void testDescription() throws Exception {
        TrashVO trash = new TrashVO();
        String desc = "a some usable pipeline";
        trash.setDescription(desc);
        assertEquals(desc,trash.getDescription());
    }
/*
    @Test
    public void testDistance() throws Exception {
        TrashVO trash = new TrashVO();
        int distance = 10;
        trash.setDistance(distance);
        assertEquals(distance,trash.getDistance());
    }
*/
    @Test
    public void testReport() throws Exception {
        TrashVO trash = new TrashVO();
        boolean report = false;
        trash.setReport(report);
        assertEquals(report,trash.getReport());
    }

    @Test
    public void testTitle() throws Exception {
        TrashVO trash = new TrashVO();
        String title = "Pipeline";
        trash.setTitle(title);
        assertEquals(title,trash.getTitle());
    }

    @Test
    public void testCondition() throws Exception {
        TrashVO condition = new TrashVO();
        String desc = "Good";
        condition.setTrash_condition(desc);
        assertEquals(desc,condition.getTrash_condition());
    }

    @Test
    public void testSize() throws Exception {
        TrashVO trash = new TrashVO();
        int size = 4;
        trash.setSize(size);
        assertEquals(size,trash.getSize());
    }

    @Test
    public void testUser() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemUser = "hakeemd";
        account.setUsername(hakeemUser);
        assertEquals(hakeemUser,account.getUsername());
    }

    @Test
    public void testail() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemEmail = "hakeem.radiansyah@ui.ac.id";
        account.setEmail(hakeemEmail);
        assertEquals(hakeemEmail,account.getEmail());
    }

    @Test
    public void testPassword() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemPassword = "pass1234";
        account.setPassword(hakeemPassword);
        assertEquals(hakeemPassword,account.getPassword());
    }

    @Test
    public void testPhone_number() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemNum = "0761943665";
        account.setPhone_number(hakeemNum);
        assertEquals(hakeemNum,account.getPhone_number());
    }

}
