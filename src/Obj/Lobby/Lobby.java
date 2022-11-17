package Obj.Lobby;

import Obj.Person.Saver;
import Obj.Person.Victim;
import Obj.Place.*;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    List<Saver> savers = new ArrayList<>();

    List<Victim> victims = new ArrayList<>();

    private FarAway farAway;
    private Field field;
    private Zabor zabor;
    private Crater crater;

    public Lobby() {

    }

    public void setLocations(FarAway farAway, Field field, Zabor zabor, Crater crater) {
        this.farAway = farAway;
        this.field = field;
        this.zabor = zabor;
        this.crater = crater;
    }

    public void setSaver(Saver... saver) {
        savers = new ArrayList<>();
        for (Saver s : saver) {
            savers.add(s);
        }
    }

    public void setVictims(Victim... victim) {
        victims = new ArrayList<>();
        for (Victim v : victim) {
            victims.add(v);
        }

    }

    private void checkVictims() {
        for (Victim v : victims) {
            if (v.getPlace().equals(farAway)) {
                System.out.println(v.getSaver().getName() + " спас " + v.getName());
                v.setRescue(true);
                v.getSaver().setAimToVictim(false);
                v.getSaver().delVictim();
            }
            if (v.isRescue()) {
                victims.remove(v);
                break;  // Ещё не доказано
            } else {
                if (v.getSaver() == null) {
                    if (!v.isUjeZval()) {
                        v.say(1);
                        v.setUjeZval(true);
                    }
                    for (Saver s : savers) {
                        if (s.getVictim() == null && s.getPlace().equals(crater)) {
                            System.out.println(s.getName() + " подобрал раненного " + v.getName() + " и понёс его к зоне эвакуации");
                            s.setVictim(v);
                            break;
                        }
                    }
                } else {
                    // терпим эвакуации
                }
            }
        }
    }

    private void checkSavers() {
        for (Saver s : savers) {
            if (s.getInSpace()) {
                savers.remove(s);
                break;
            }
            if (s.getVictim() == null) {
                if (!s.isAimToVictim()) {
                    for (Victim v : victims) {
                        if (v.getSaver() == null) {
                            s.setAimToVictim(true);
                            break;
                        }
                    }

                } else if (s.getPlace().equals(farAway)) {
                    s.goTo(field);
                } else if (s.getPlace().equals(field)) {
                    s.goTo(zabor);
                } else if (s.getPlace().equals(zabor)) {
                    if (!zabor.isHaveHole()) {
                        if (s.try_to_jumpover()) {
                            System.out.println(s.getName() + " вырвал кусок забора");
                            zabor.setHaveHole(true);
                        } else {
                            break;
                        }
                    } else {
                        s.goTo(crater);
                    }
                }
            } else {
                if (s.getPlace().equals(crater)) {
                    s.goTo(zabor);
                } else if (s.getPlace().equals(zabor)) {
                    s.goTo(field);
                } else if (s.getPlace().equals(field)) {
                    s.goTo(farAway);
                }
            }
        }
    }

    public void update() {
        this.checkVictims();
        this.checkSavers();
    }
}
