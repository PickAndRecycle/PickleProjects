package com.pickle.rest;

import com.pickle.service.TrashService;
import com.pickle.vo.ResultVO;
import com.pickle.vo.TrashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Yanuar Wicaksana on 12/3/15.
 */

@RestController
@RequestMapping("/trashnotification")
public class TrashNotificationController {

    @Autowired
    public TrashService trashService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@PathVariable("id") String secureId, @RequestBody TrashVO voInput){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                try {
                    return trashService.updateWithNotification(secureId, voInput);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        return handler.getResult();
    }
}
