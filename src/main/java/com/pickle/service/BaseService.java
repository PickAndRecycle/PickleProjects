package com.pickle.service;

import com.pickle.vo.ArticleVO;
import com.pickle.vo.BaseVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface BaseService<V extends BaseVO, SID extends String> {

    /**
     * Add model from VO
     * @param vo
     * @return
     */
    public V add(V vo);

    /**
     * Update model
     * @param sid secure id
     * @return
     */
    public V update(SID sid, V vo);

    /**
     * Delete model
     * @param sid secure id
     * @return
     */
    public Boolean delete(SID sid);

    /**
     * Find all model
     * @return
     */
    public abstract Collection<V> findAll();

    /**
     * Find by Id
     * @param sid secure id
     * @return
     */
    public abstract V findById(SID sid);

    public V addFile(V vo, MultipartFile file) throws IOException;


}
