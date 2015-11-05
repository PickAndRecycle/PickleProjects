package com.pickle.persistence.repository;

import com.pickle.persistence.domain.Trash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */
public interface TrashRepository extends JpaRepository<Trash, Integer> {

    public Trash findBySecureId(String secureId);

    public List<Trash> findAll();
}
