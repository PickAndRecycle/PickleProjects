package com.pickle.service.impl;

import com.pickle.vo.AccountVO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hakeem on 11/24/2015.
 */
public class AccountVOTest {

    @Test
    public void testUsername() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemUser = "hakeemd";
        account.setUsername(hakeemUser);
        assertEquals(hakeemUser,account.getUsername());
    }

    @Test
    public void testEmail() throws Exception {
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
