package com.pickle.rest;

import com.pickle.service.TrashService;
import com.pickle.vo.AccountVO;
import com.pickle.vo.ResultVO;
import com.pickle.vo.TrashVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/trash")
public class TrashController {
    @Autowired
    private TrashService TrashService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody TrashVO voInput) {

        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                TrashVO vo = TrashService.add(voInput);
                return vo == null ? null : vo.getId();
            }
        };
        return handler.getResult();

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultVO> findById(@PathVariable("id") String secureId){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return TrashService.findById(secureId);
            }
        };
        return handler.getResult();
    }
}
