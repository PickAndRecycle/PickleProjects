package com.pickle.service.impl;

import com.pickle.converter.AccountVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Account;
import com.pickle.service.AccountService;
import com.pickle.vo.AccountVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pickle.persistence.repository.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by danieldeem on 11/6/2015.
 */

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    AccountVoConverter accountVoConverter;

    @Autowired
    AccountRespository accountRespository;

    @Override
    public AccountVO add(AccountVO vo) {
        //input to database
        Account account = accountVoConverter.transferVOToModel(vo,null);

        accountRespository.save(account);

        vo.setId(account.getSecureId());

        return vo;
    }

    @Override
    public AccountVO update(String s, AccountVO vo) {
        Account account = accountRespository.findBySecureId(s);

        account = accountVoConverter.transferVOToModel(vo,account);

        accountRespository.saveAndFlush(account);

        return accountVoConverter.transferModelToVO(account, null);

    }

    @Override
    public Boolean delete(String s) {
        return null;
    }

    @Override
    public Collection<AccountVO> findAll() {
        Collection<Account> accountList = accountRespository.findAll();

        return accountVoConverter.transferListOfModelToListOfVO(accountList, null);
    }

    @Override
    public AccountVO findById(String s) {

        Account account = accountRespository.findBySecureId(s);

        if (account == null) {
            throw new ServiceException("Account item not found: " + s);
        }

        return accountVoConverter.transferModelToVO(account, null);
    }

    @Override
    public AccountVO addFile(AccountVO vo, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public AccountVO addAccount(AccountVO vo, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public AccountVO findByName(String name) {
        return null;
    }
}

