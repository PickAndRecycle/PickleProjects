package com.pickle.service.impl;

import com.pickle.converter.TrashVoConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Trash;
import com.pickle.persistence.repository.TrashRepository;
import com.pickle.service.TrashService;
import com.pickle.vo.TrashVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger logger = LoggerFactory.getLogger(TrashServiceImpl.class);


    @Autowired
    TrashVoConverter trashVoConverter;

    @Autowired
    TrashRepository trashRepository;

    @Override
    public TrashVO add(TrashVO vo) {

        return null;
    }

    @Override
    public TrashVO update(String s, TrashVO vo) {

        return null;
    }

    @Override
    public Boolean delete(String s) {
       return null;
    }

    @Override
    public Collection<TrashVO> findAll() {
        Collection<Trash> TrashList = trashRepository.findAll();

        return trashVoConverter.transferListOfModelToListOfVO(TrashList, null);
    }

    @Override
    public TrashVO findById(String s) {

        Trash trash = trashRepository.findBySecureId(s);

        if (trash == null) {
            throw new ServiceException("Trash item not found: " + s);
        }

        return trashVoConverter.transferModelToVO(trash, null);
    }
}

