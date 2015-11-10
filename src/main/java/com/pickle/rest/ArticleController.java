package com.pickle.rest;

import com.pickle.persistence.domain.Article;
import com.pickle.service.ArticleService;
import com.pickle.vo.ArticleVO;
import com.pickle.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kamar on 10/11/2015.
 */

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultVO> findAll(){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return articleService.findAll();
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResultVO> findById(@PathVariable("id") String secureId){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return articleService.findById(secureId);
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestBody ArticleVO voInput){

        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                ArticleVO vo = articleService.add(voInput);
                return vo == null ? null : vo.getId();
            }
        };
        return handler.getResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ResultVO> edit(@PathVariable("id") String secureId, @RequestBody ArticleVO voInput){
        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() {
                return articleService.update(secureId, voInput);
            }
        };
        return handler.getResult();
    }

}
