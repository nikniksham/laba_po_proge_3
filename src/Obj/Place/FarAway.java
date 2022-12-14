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
                System.out.println("Сделав несколько шагов " + s.getName() + " почувствовал, что тяжесть как будто уменьшилась," +
                        " а сделав еще шаг, он неожиданно оторвался от земли и взвился вместе с " + s.getVictim().getName());
                System.out.println(s.getName() + " растерялся в первый момент, но потом вспомнил, что привязан к веревке, и закричал");
                if (s.getHaveRope()) {
                    System.out.println("Коротышки вспомнили про свою обязанность и притянули " + s.getName() + " к дому");
                } else {
                    s.setInSpace(true);
                    System.out.println("Увы, но верёвка порвалась");
                    System.out.println("Запомните дети, всегда надо соблюдать технику безопасности");
                    s.getVictim().setRescue(true);
                    return true;
                }
            } else {
                System.out.println(s.getName() + " не выпендривался и просто донёс " + s.getVictim().getName() + " до дома");
            }
            Victim v = s.getVictim();
            System.out.println(s.getName() + " спас " + v.getName());
            v.setRescue(true);
            s.setAimToVictim(false);
            v.getSaver().delVictim();
            if (Math.random() > 0.3) {
                System.out.println("Эвакуация прошла успешна");
            } else {
                System.out.println("Человека конечно эвакуировали, но верёвка порвалась");
                s.setHaveRope(false);
            }
        }
        return false;
    }
}
