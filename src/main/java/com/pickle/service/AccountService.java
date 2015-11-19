package com.pickle.service;

import com.pickle.vo.AccountVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by danieldeem on 11/6/2015.
 */
public interface AccountService extends BaseService<AccountVO,String> {
    AccountVO addAccount(AccountVO vo, MultipartFile file) throws IOException;
}
