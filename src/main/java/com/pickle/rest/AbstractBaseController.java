package com.pickle.rest;

import com.pickle.exception.ServiceException;
import com.pickle.util.RestUtil;
import com.pickle.util.StatusCode;
import com.pickle.vo.ResultVO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public abstract class AbstractBaseController {

    protected static abstract class AbstractRequestHandler {

        public ResponseEntity<ResultVO> getResult() {
            ResultVO result = new ResultVO();
            try {
                Object obj = processRequest();
                if (obj != null) {
                    result.setMessage(StatusCode.OK.name());
                    result.setResult(obj);
                }
            } catch (ServiceException e) {
                result.setMessage(e.getCode().name());
                result.setResult(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return RestUtil.getJsonResponse(result);
        }

        public abstract Object processRequest() throws IOException;

    }

}
