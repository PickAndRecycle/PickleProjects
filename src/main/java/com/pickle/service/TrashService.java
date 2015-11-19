package com.pickle.service;

import com.pickle.vo.TrashVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Yanuar Wicaksana on 11/2/15.
 */
public interface TrashService extends BaseService<TrashVO, String> {
    TrashVO addFile(TrashVO vo, MultipartFile file) throws IOException;
}
