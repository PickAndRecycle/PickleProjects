package com.pickle.service;


import com.pickle.vo.ArticleVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Yanuar Wicaksana on 11/14/15.
 */
public interface ArticleService extends BaseService<ArticleVO,String>{

    ArticleVO addArticle(ArticleVO vo, MultipartFile file) throws IOException;
}
