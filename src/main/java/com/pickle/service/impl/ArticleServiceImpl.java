package com.pickle.service.impl;

import com.pickle.exception.ServiceException;
import com.pickle.persistence.repository.ArticleRepository;
import com.pickle.converter.ArticleVoConverter;
import com.pickle.persistence.domain.Article;
import com.pickle.service.ArticleService;
import com.pickle.vo.ArticleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by kamar on 10/11/2015.
 */

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    public static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);


    @Autowired
    ArticleVoConverter articleVoConverter;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public ArticleVO add(ArticleVO vo) {
        //input to database
        Article article = articleVoConverter.transferVOToModel(vo,null);

        articleRepository.save(article);

        vo.setId(article.getSecureId());

        return vo;
    }

    @Override
    public ArticleVO update(String s, ArticleVO vo) {

        Article article = articleRepository.findBySecureId(s);

        article = articleVoConverter.transferVOToModel(vo,article);

        articleRepository.saveAndFlush(article);

        return articleVoConverter.transferModelToVO(article, null);

    }

    @Override
    public Boolean delete(String s) {
        return null;
    }

    @Override
    public Collection<ArticleVO> findAll() {
        Collection<Article> ArticleList = articleRepository.findAll();

        return articleVoConverter.transferListOfModelToListOfVO(ArticleList, null);
    }

    @Override
    public ArticleVO findById(String s) {

        Article article = articleRepository.findBySecureId(s);

        if (article == null) {
            throw new ServiceException("Article item not found: " + s);
        }

        return articleVoConverter.transferModelToVO(article, null);
    }
}
