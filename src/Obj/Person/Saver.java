package Obj.Person;

import Obj.Grav;
import Obj.Place.Place;

public class Saver extends Person implements SaySomething, FeelGravity {

    private boolean inSpace = false;

    public Saver(String name) {
        super(name);
    }

    private Victim victim;

    private boolean aimToVictim;

    public boolean isAimToVictim() {
        return aimToVictim;
    }

    public boolean getInSpace() {
        return inSpace;
    }

    public void setAimToVictim(boolean aimToVictim) {
        this.aimToVictim = aimToVictim;
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
        victim.setSaver(this);
    }

    public Victim getVictim() {
        return victim;
    }

    public void delVictim() {
        this.victim.delSaver();
        this.victim = null;
    }

    public void goTo(Place newLocation) {
        if (this.victim != null) {
            this.victim.setPlace(newLocation);
        }
        this.place = newLocation;
        System.out.println(this.name + " пришёл в " + newLocation.getName() + ", здесь действует " + this.feeling(newLocation.getGrav()));
    }

    public boolean try_to_jumpover() {
        if (this.getPlace().getGrav() == Grav.NO) {
            this.inSpace = true;
            System.out.println("А всё, прыгать в условиях невесомости было плохой и спасатель улетел в космос");
            return false;
        } else {
            System.out.println(this.name + " хотел перепрыгнуть, но не получилось, гравитация слишком сильна");
            return true;
        }
    }

    @Override
    public void say(int num) {
        String res = switch (num) {
            case 1 -> name + " прислушался";
            case 2 -> name + " подбежал к " + place.getPadej(3);
            case 3 -> name + " хотел вскарабкаться, но не получилось";
            case 4 -> name + " услышал жалобный стон";
            case 5 -> name + " выломал доску в заборе";
            case 6 -> name + " увидел друга";
            case 7 -> name + " схватил друга под мышки и взвалил его на спину";
            case 8 -> name + " сделал шаг";
            case 9 -> name + " полетел вместе с другом";
            default -> "Мы не знаем, что сделал " + name + ", но очевидно, что это был гнусный поступок";
        };
        System.out.println(res);
    }

    @Override
    public String feeling(Grav grav) {
        String what = switch (grav) {
            case STRONG -> "сильная гравитация";
            case WEAK -> "слабая гравитация";
            case NO -> "невесомость";
        };

        return what;
    }
}
