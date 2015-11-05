package com.pickle.rest;

import com.pickle.service.TrashService;
import com.pickle.vo.ResultVO;
import com.pickle.vo.TrashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yanuar Wicaksana on 11/2/15.
 */

@RestController
@RequestMapping("/trash")
public class TrashController {

    @Autowired
    private TrashService trashService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultVO> findAll(){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return trashService.findAll();
            }
        };
        return handler.getResult();
    }


}
