package com.pickle.persistence.repository;

import com.pickle.persistence.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yanuar Wicaksana on 12/2/15.
 */
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    public Notification findBySecureId(String secureId);

    public Notification findByUsername(String username);
}
