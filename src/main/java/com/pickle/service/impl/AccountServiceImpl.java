package com.pickle.service.impl;

import com.pickle.converter.AccountVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Account;
import com.pickle.persistence.repository.AccountRespository;
import com.pickle.service.AccountService;
import com.pickle.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by kamar on 4/11/2015.
 */

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountVoConverter accountVoConverter;

    @Autowired
    AccountRespository accountRespository;

    @Override
    public AccountVO add(AccountVO vo) {

        Account account = accountVoConverter.transferVOToModel(vo, null);

        accountRespository.save(account);

        vo.setId(account.getSecureId());

        return vo;
    }

    @Override
    public AccountVO update(String s, AccountVO vo) {

        Account account = accountRespository.findBySecureId(s);

        account = accountVoConverter.transferVOToModel(vo, account);

        accountRespository.saveAndFlush(account);

        return accountVoConverter.transferModelToVO(account, null);

    }

    @Override
    public Boolean delete(String s) {
        Account account = accountRespository.findBySecureId(s);

        if (account == null) {
            throw new ServiceException("Account not found: " + s);
        }

        accountRespository.delete(account.getId());

        if(accountRespository.exists(account.getId())){
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;
        }
    }

    @Override
    public Collection<AccountVO> findAll() {
        Collection<Account> AccountList = accountRespository.findAll();

        return accountVoConverter.transferListOfModelToListOfVO(AccountList, null);
    }

    @Override
    public AccountVO findById(String s) {return null;}

}
