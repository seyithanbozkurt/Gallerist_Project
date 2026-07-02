package com.example.gallerist.Exception;

public class BaseException extends RuntimeException{

    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());
    }
}
