package Obj.CustomException;

public class Checked extends Exception {
    public Checked(String errorMessage, Throwable err) {
        super(errorMessage);
    }
}
