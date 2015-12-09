package com.pickle.converter;

import com.pickle.persistence.domain.Account;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by danieldeem on 11/6/2015.
 */

@Component
public class AccountVoConverter implements IBaseVoConverter<AccountVO,Account> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Account transferVOToModel(AccountVO vo, Account model) {
        if (model == null) model = new Account();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"username", "email", "password", "phone_number"});

        return model;
    }

    public Collection<AccountVO> transferListOfModelToListOfVO(Collection<Account> models, Collection<AccountVO> vos) {
        if (vos == null) vos = new ArrayList<AccountVO>();

        if (models == null) return vos;

        for(Account model: models){
            AccountVO vo = new AccountVO();
            transferModelToVO(model,vo);
            vos.add(vo);
        }
        return vos;
    }


    public AccountVO transferModelToVO(Account model, AccountVO vo) {
        if (vo == null) vo = new AccountVO();

        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"username", "email", "password", "phone_number"});

        return vo;
    }
}
