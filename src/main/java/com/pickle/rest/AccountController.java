package com.pickle.rest;

import com.pickle.persistence.domain.Account;
import com.pickle.service.AccountService;
import com.pickle.vo.ResultVO;
import com.pickle.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hakeem on 11/6/2015.
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultVO> findAll(){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return accountService.findAll();
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResultVO> findById(@PathVariable("id") String secureId){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return accountService.findById(secureId);
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody AccountVO voInput){

        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                AccountVO vo = accountService.add(voInput);
                return vo == null ? null : vo.getId();
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@PathVariable("id") String secureId, @RequestBody AccountVO voInput){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return accountService.update(secureId, voInput);
            }
        };
        return handler.getResult();
    }

}
