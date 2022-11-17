package Obj.Place;

import Obj.Grav;

public class Zabor extends Place {

    private boolean haveHole = false;

    public Zabor(String name, Grav grav) {
        super(name, grav);
    }

    public void setHaveHole(boolean haveHole) {
        this.haveHole = haveHole;
    }

    public boolean isHaveHole() {
        return haveHole;
    }
}
