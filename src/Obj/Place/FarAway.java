package Obj.Place;

import Obj.Grav;
import Obj.Person.Saver;
import Obj.Person.Victim;

public class FarAway extends Place {
    public FarAway(String name, Grav grav) {
        super(name, grav);
    }

    @Override
    public boolean action(Saver s) {
        if (s.getVictim() != null) {
            if (this.getGrav() == Grav.NO) {
                if (s.getHaveRope()) {
                    System.out.println(s.getName() + " полетел, но вовремя закричал, коротышки вспомнили про свою обязанность и притянули его к дому");
                } else {
                    s.setInSpace(true);
                    System.out.println("Запомните дети, всегда надо соблюдать технику безопасности");
                    return true;
                }
            }
            Victim v = s.getVictim();
            System.out.println(s.getName() + " спас " + v.getName());
            v.setRescue(true);
            s.setAimToVictim(false);
            v.getSaver().delVictim();
            if (Math.random() > 0.2) {
                System.out.println("Эвакуация прошла успешна");
            } else {
                System.out.println("Человека конечно эвакуировали, но верёвка порвалась");
                s.setHaveRope(false);
            }
        }
        return false;
    }
}
