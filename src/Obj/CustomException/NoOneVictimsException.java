package Obj.CustomException;

public class NoOneVictimsException extends Exception { // checked exception
    public NoOneVictimsException(String errorMessage) {
        super(errorMessage);
    }
}
