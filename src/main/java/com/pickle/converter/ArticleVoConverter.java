package com.pickle.converter;

import com.pickle.persistence.domain.Article;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yanuar Wicaksana on 11/14/15.
 */

@Component
public class ArticleVoConverter implements IBaseVoConverter<ArticleVO, Article> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Article transferVOToModel(ArticleVO vo, Article model) {
        if (model == null) model = new Article();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"title", "photo_url", "content"});

        return model;
    }

    @Override
    public Collection<ArticleVO> transferListOfModelToListOfVO(Collection<Article> models, Collection<ArticleVO> vos) {
        if (vos == null) vos = new ArrayList<ArticleVO>();

        if (models == null) return vos;

        for(Article model: models){
            ArticleVO vo = new ArticleVO();
            transferModelToVO(model,vo);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public ArticleVO transferModelToVO(Article model, ArticleVO vo) {
        if (vo == null) vo = new ArticleVO();

        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"title", "photoUrl", "content"});

        return vo;
    }
}
