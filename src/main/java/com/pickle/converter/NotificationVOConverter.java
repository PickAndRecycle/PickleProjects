package com.pickle.converter;

import com.pickle.persistence.domain.Notification;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.NotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yanuar Wicaksana on 12/3/15.
 */

@Component
public class NotificationVOConverter implements IBaseVoConverter<NotificationVO,Notification> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Notification transferVOToModel(NotificationVO vo, Notification model) {
        if (model == null) model = new Notification();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"token", "username"});

        return model;
    }

    @Override
    public Collection<NotificationVO> transferListOfModelToListOfVO(Collection<Notification> models, Collection<NotificationVO> vos) {
        if (vos == null) vos = new ArrayList<NotificationVO>();

        if (models == null) return vos;

        for(Notification model: models){
            NotificationVO vo = new NotificationVO();
            transferModelToVO(model,vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public NotificationVO transferModelToVO(Notification model, NotificationVO vo) {
        if (vo == null) vo = new NotificationVO();

        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"token", "username"});

        return vo;
    }
}
