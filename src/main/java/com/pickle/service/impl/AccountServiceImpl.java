package com.pickle.service.impl;

import com.pickle.persistence.domain.Account;
import com.pickle.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pickle.persistence.repository.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by danieldeem on 11/6/2015.
 */

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    AccountVoConverter trashVoConverter;

    @Autowired
    AccountRespository accountRespository;
}
