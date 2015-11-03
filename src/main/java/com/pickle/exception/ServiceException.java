package com.pickle.exception;

import com.pickle.util.StatusCode;

public class ServiceException extends RuntimeException {

    private StatusCode code = StatusCode.ERROR;

	public ServiceException(){
		super();
	}

    public ServiceException(String message){
		super(message);
	}

    public ServiceException(StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

}
