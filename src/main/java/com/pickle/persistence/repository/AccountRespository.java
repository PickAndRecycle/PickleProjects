package com.pickle.persistence.repository;

import com.pickle.persistence.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 11/2/2015.
 */
public interface AccountRespository  extends JpaRepository<Account, Integer> {
    public Account findBySecureId(String SecureId);
}
