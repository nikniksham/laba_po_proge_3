package Obj.CustomException;

public class NoOneVictims extends Exception { // checked exception
    public NoOneVictims(String errorMessage) {
        super(errorMessage);
    }
}
