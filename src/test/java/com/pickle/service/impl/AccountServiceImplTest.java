package com.pickle.service.impl;

import com.pickle.service.AccountService;
import com.pickle.vo.AccountVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Hakeem on 11/24/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAdd() throws Exception {

        AccountVO accountVO = new AccountVO();
        accountVO.setUsername("username");
        accountVO.setPassword("pass1234");
        accountVO.setPhone_number("1500366");
        accountVO.setEmail("user@email.com");

        AccountVO resultVO = accountService.add(accountVO);
        assertEquals(accountVO.getUsername(), resultVO.getUsername());
    }

    @Test
    public void testUpdate() throws Exception {

        AccountVO accountVO = new AccountVO();
        accountVO.setUsername("username2");
        accountVO.setPassword("pass1234");
        accountVO.setEmail("user2@email.com");
        AccountVO tempVo = accountService.add(accountVO);

        String phone = "1500366";
        accountVO.setPhone_number(phone);
        AccountVO resultVO = accountService.update(tempVo.getUsername(), accountVO);
        assertEquals(resultVO.getPhone_number(),phone);

    }

}
