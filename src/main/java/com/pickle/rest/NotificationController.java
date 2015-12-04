package com.pickle.rest;

import com.pickle.service.NotificationService;
import com.pickle.vo.NotificationVO;
import com.pickle.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yanuar Wicaksana on 12/3/15.
 */

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultVO> findAll(){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return notificationService.findAll();
            }

        };
        return handler.getResult();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody NotificationVO voInput){

        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                NotificationVO vo = notificationService.add(voInput);
                return vo == null ? null : vo.getId();
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResultVO> delete(@PathVariable("id") String secureId) {
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return notificationService.delete(secureId);
            }
        };
        return handler.getResult();
    }

}
