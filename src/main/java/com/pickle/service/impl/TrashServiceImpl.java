package com.pickle.service.impl;

import com.pickle.converter.TrashVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Trash;
import com.pickle.persistence.repository.TrashRepository;
import com.pickle.service.TrashService;
import com.pickle.vo.TrashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Yanuar Wicaksana on 11/2/15.
 */


@Service
@Transactional(readOnly = true)
public class TrashServiceImpl implements TrashService{

    @Autowired
    TrashVoConverter trashVoConverter;

    @Autowired
    TrashRepository trashRepository;

    @Override
    public TrashVO add(TrashVO vo) {

        Trash trash = trashVoConverter.transferVOToModel(vo, null);

        trashRepository.save(trash);

        vo.setId(trash.getSecureId());

        return vo;
    }

    @Override
    public TrashVO update(String s, TrashVO vo) {

        Trash trash = trashRepository.findBySecureId(s);

        trash = trashVoConverter.transferVOToModel(vo, trash);

        trashRepository.saveAndFlush(trash);

        return trashVoConverter.transferModelToVO(trash, null);

    }

    @Override
    public Boolean delete(String s) {
        Trash trash = trashRepository.findBySecureId(s);

        if (trash == null){
            throw new ServiceException("Trash not found: " + s);
        }

        trashRepository.delete(trash.getId());

        if(trashRepository.exists(trash.getId())){
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;
        }
    }

    @Override
    public Collection<TrashVO> findAll() {
        Collection<Trash> TrashList = trashRepository.findAll();

        return trashVoConverter.transferListOfModelToListOfVO(TrashList, null);
    }

    @Override
    public TrashVO findById(String s) {
        return null;
    }
}

