package com.pickle.rest;

import com.google.gson.Gson;
import com.pickle.persistence.domain.Article;
import com.pickle.service.ArticleService;
import com.pickle.vo.ArticleVO;
import com.pickle.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Yanuar Wicaksana on 11/14/15.
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

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResultVO> add(@RequestParam(value = "voInput", required = false) String voInput,
                                        @RequestParam(value = "file", required = false) final MultipartFile file){

        AbstractBaseController.AbstractRequestHandler handler = new AbstractBaseController.AbstractRequestHandler() {
            @Override
            public Object processRequest() throws IOException {
                System.out.println(file+"photo");
                Gson gson = new Gson();
                final ArticleVO vo = gson.fromJson(voInput, ArticleVO.class);
                ArticleVO result = articleService.addFile(vo, file);
                return result == null ? null : result.getId();
            }
        };
        return handler.getResult();
    }


}
