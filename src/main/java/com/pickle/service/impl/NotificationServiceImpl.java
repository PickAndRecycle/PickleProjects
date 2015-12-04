package com.pickle.service.impl;

import com.pickle.converter.NotificationVOConverter;
import com.pickle.exception.ServiceException;
import com.pickle.persistence.domain.Notification;
import com.pickle.persistence.repository.NotificationRepository;
import com.pickle.service.NotificationService;
import com.pickle.vo.NotificationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;


/**
 * Created by Yanuar Wicaksana on 12/3/15.
 */

@Service
@Transactional(readOnly = true)
public class NotificationServiceImpl implements NotificationService{

    public static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    NotificationVOConverter notificationVOConverter;

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationVO add(NotificationVO vo) {
        Notification notification = notificationVOConverter.transferVOToModel(vo,null);

        notificationRepository.save(notification);

        vo.setId(notification.getSecureId());

        return vo;

    }

    @Override
    public NotificationVO addFile(NotificationVO vo, MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public NotificationVO findByUsername(String username) {
        return null;
    }

    @Override
    public NotificationVO findById(String s) {
        return null;
    }

    @Override
    public NotificationVO update(String s, NotificationVO vo) {
        return null;
    }

    @Override
    public Collection<NotificationVO> findAll() {
        Collection<Notification> NotificationList = notificationRepository.findAll();

        return notificationVOConverter.transferListOfModelToListOfVO(NotificationList, null);
    }

    @Override
    public Boolean delete(String s) {
        Notification notification = notificationRepository.findBySecureId(s);

        if (notification == null) {
            throw new ServiceException("notification not found: " + s);
        }

        Integer id = notification.getId();

        notificationRepository.delete(id);

        if (!notificationRepository.exists(id)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
