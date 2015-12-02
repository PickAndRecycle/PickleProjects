package com.pickle.converter;

import com.pickle.persistence.domain.Trash;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.TrashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */

@Component
public class TrashVoConverter implements IBaseVoConverter<TrashVO, Trash> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Trash transferVOToModel(TrashVO vo, Trash model) {
        if (model == null) model = new Trash();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"categories", "username", "status", "description", "pickerUsername", "photo_url", "latitude", "longitude",
                "report", "title", "trash_condition", "size"});
        /*
        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"categories", "username", "status", "description", "photo_url", "title", "trash_condition"});*/
        return model;
    }

    @Override
    public Collection<TrashVO> transferListOfModelToListOfVO(Collection<Trash> models, Collection<TrashVO> vos) {
        if (vos == null) vos = new ArrayList<TrashVO>();

        if (models == null) return vos;

        for(Trash model: models){
            TrashVO vo = new TrashVO();
            transferModelToVO(model,vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public TrashVO transferModelToVO(Trash model, TrashVO vo) {
        if (vo == null) vo = new TrashVO();

        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"categories", "username", "status", "description", "pickerUsername", "photo_url", "latitude", "longitude",
                        "report", "title", "trash_condition", "size"});
        /*
        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"categories", "username","username", "description", "photo_url", "title", "trash_condition"});
        */
        return vo;
    }
}
