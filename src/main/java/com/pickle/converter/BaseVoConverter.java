package com.pickle.converter;

import com.pickle.persistence.domain.Base;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.BaseVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class BaseVoConverter implements IBaseVoConverter<BaseVO, Base> {

    /**
     * transfer value from vo object to domain object
     * for enum value, please do manually using Enum.values()[ordinal]
     *
     * @param vo
     * @param model
     * @return
     */
    @Override
    public Base transferVOToModel(BaseVO vo, Base model) {

        // Generated values should not be modified explicitly
        /*ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"id", "creationDate", "createdBy", "modificationDate", "modifiedBy", "version", "active"},
                new String[]{"id", "creationDate", "createdBy", "modificationDate", "modifiedBy", "version", "active"});*/
        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"deleted"},
                new String[]{"deleted"});

        return model;
    }

    /**
     * transfer value from list of domain object to list of vo object
     *
     * @param models
     * @param vos
     * @return
     */
    @Override
    public Collection<BaseVO> transferListOfModelToListOfVO(Collection<Base> models, Collection<BaseVO> vos) {

        if(null == vos) vos = new ArrayList<BaseVO>();

        if(null == models) return vos;

        for(Base model : models){
            BaseVO vo = new BaseVO();
            transferModelToVO(model, vo);
            vos.add(vo);
        }
        return vos;
    }

    /**
     * transfer value from domain object to vo object
     *
     * @param model
     * @param vo
     * @return
     */
    @Override
    public BaseVO transferModelToVO(Base model, BaseVO vo) {
        ExtendedSpringBeanUtil.copySpecificProperties(model,vo,
                new String[]{"id", "secureId", "creationDate", "createdBy", "modificationDate", "modifiedBy", "deleted"},
                new String[]{"internalId", "id", "creationDate", "createdBy", "modificationDate", "modifiedBy", "deleted"});
        return vo;
    }
}