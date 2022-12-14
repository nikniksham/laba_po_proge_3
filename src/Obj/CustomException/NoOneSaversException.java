package Obj.CustomException;

public class NoOneSaversException extends RuntimeException { // unchecked Exception
    public NoOneSaversException(String errorMessage) {
        super(errorMessage);
    }
}
