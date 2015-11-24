package com.pickle.service.impl;

import com.pickle.vo.AccountVO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Hakeem on 11/24/2015.
 */
public class AccountServiceImplTest {

    @Test
    public void testAdd() throws Exception {
        AccountVO account = new AccountVO();
        String hakeemd = "hakeemd";
        account.setUsername(hakeemd);
        AccountServiceImpl accService = new AccountServiceImpl();
        AccountVO acc  = accService.add(account);
        assertEquals(hakeemd,acc);
    }

    @Test
    public void testUpdate() throws Exception {


    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }

}
