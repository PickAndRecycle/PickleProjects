package com.pickle.persistence.repository;

import com.pickle.persistence.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamar on 10/11/2015.
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    public Article findBySecureId(String SecureId);
}
