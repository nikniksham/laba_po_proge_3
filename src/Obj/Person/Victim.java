package Obj.Person;

public class Victim extends Person implements SaySomething {

    public Victim(String name) {
        super(name);
    }

    boolean isRescue = false;
    boolean ujeZval = false;

    public boolean isUjeZval() {
        return ujeZval;
    }

    public void setUjeZval(boolean ujeZval) {
        this.ujeZval = ujeZval;
    }

    private Saver saver;

    public void setSaver(Saver saver) {
        this.saver = saver;
    }

    public Saver getSaver() {
        return saver;
    }

    public void delSaver() {
        this.saver = null;
    }

    public boolean isRescue() {
        return isRescue;
    }

    public void setRescue(boolean rescue) {
        isRescue = rescue;
    }

    @Override
    public void say(int num) {
        String res = switch (num) {
            case 1 -> name + " позвал на помощь";
            case 2 -> name + " лежал на земле за " + place.getPadej(5);
            case 3 -> name + " увидел друга";
            default -> "Мы не знаем, что сделал " + name + ", но очевидно, что это был гнусный поступок";
        };
        System.out.println(res);
    }
}
