package com.pickle.service;

import com.pickle.persistence.domain.Notification;
import com.pickle.vo.NotificationVO;

/**
 * Created by Yanuar Wicaksana on 12/3/15.
 */
public interface NotificationService extends BaseService<NotificationVO,String> {

    public NotificationVO findByUsername(String username);
}
