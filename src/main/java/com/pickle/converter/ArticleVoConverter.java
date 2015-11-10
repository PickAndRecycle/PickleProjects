package com.pickle.converter;

import com.pickle.persistence.domain.Article;
import com.pickle.util.ExtendedSpringBeanUtil;
import com.pickle.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kamar on 10/11/2015.
 */
public class ArticleVoConverter implements IBaseVoConverter<ArticleVO, Article> {

    @Autowired
    private BaseVoConverter baseVoConverter;

    @Override
    public Article transferVOToModel(ArticleVO vo, Article model) {
        if (model == null) model = new Article();

        baseVoConverter.transferVOToModel(vo, model);

        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"title", "photo_data", "content"});
        /*
        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"categories", "username", "status", "description", "photo_url", "title", "trash_condition"});*/
        return model;
    }

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


    public ArticleVO transferModelToVO(Article model, ArticleVO vo) {
        if (vo == null) vo = new ArticleVO();

        baseVoConverter.transferModelToVO(model, vo);

        ExtendedSpringBeanUtil.copySpecificProperties(model, vo,
                new String[]{"title", "photo_data", "content"});
        /*
        ExtendedSpringBeanUtil.copySpecificProperties(vo, model,
                new String[]{"categories", "username","username", "description", "photo_url", "title", "trash_condition"});
        */
        return vo;
    }


}
