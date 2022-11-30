package Obj.Place;

import Obj.Grav;
import Obj.Person.Saver;

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

    @Override
    public boolean action(Saver s) {
        if (!this.isHaveHole()) {
            if (s.try_to_jumpover()) {
                System.out.println(s.getName() + " вырвал кусок забора");
                this.setHaveHole(true);
            } else {
                return true;
            }
        }
        return false;
    }
}
