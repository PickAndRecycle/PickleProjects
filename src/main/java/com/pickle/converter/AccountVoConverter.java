package com.pickle.converter;

import com.pickle.persistence.domain.Account;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kamar on 4/11/2015.
 */
public class AccountVoConverter implements IBaseVoConverter<AccountVO, Account> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Account transferVOToModel(AccountVO vo, Account model) {
        if (model == null) model = new Account();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"username", "password", "email", "phone number", "photo url"});
        return model;
    }

    @Override
    public Collection<AccountVO> transferListOfModelToListOfVO(Collection<Account> models, Collection<AccountVO> vos) {
        if (vos == null) vos = new ArrayList<AccountVO>();

        if (models == null) return vos;

        for(Account model: models){
            AccountVO vo = new AccountVO();
            transferModelToVO(model, vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public AccountVO transferModelToVO(Account model, AccountVO vo) {
        if (vo == null) vo = new AccountVO();
        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"username", "password", "email", "phone number", "photo url"});
        return vo;
    }
}
