package exceptions;

import enums.ExceptionEnum;

public class ApplicationException extends RuntimeException{
    public ApplicationException(ExceptionEnum ex){
        super(ex.getMessage());
    }
}
