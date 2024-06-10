package com.web_client.Exceptions;

import java.util.List;

/**
 * class ini digunakan untuk throwing back exception
 * ketika mendapati error 400
 */
public class ClientErrorExceptions extends RuntimeException{
    private List<String> errorList;
    public ClientErrorExceptions(String message, List<String> errorList) {
        super(message);
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
