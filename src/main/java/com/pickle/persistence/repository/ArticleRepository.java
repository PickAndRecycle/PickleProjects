package com.pickle.persistence.repository;

import com.pickle.persistence.domain.Account;
import com.pickle.persistence.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yanuar Wicaksana on 11/14/15.
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    public Article findBySecureId(String SecureId);
}
