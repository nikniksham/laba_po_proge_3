package Obj.Lobby;

import Obj.CustomException.NoOneSaversException;
import Obj.CustomException.NoOneVictimsException;
import Obj.Person.Saver;
import Obj.Person.Victim;
import Obj.Place.*;
import Obj.Story.Story;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    List<Saver> savers = new ArrayList<>();

    List<Victim> victims = new ArrayList<>();

    Story story;

    private FarAway farAway;
    private Field field;
    private Zabor zabor;
    private Crater crater;

    public Lobby(Story story) {
        this.story = story;
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

    private void checkVictims() throws NoOneVictimsException {
        for (Victim v : victims) {
            if (v.isRescue()) {
                victims.remove(v);
                break;
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
                    // терпим, ждём эвакуацию
                }
            }
        }
        if (this.victims.size() == 0) {
            this.story.setRunning(false);
            if (this.savers.size() > 0) {
                throw new NoOneVictimsException("Жертвы кончились, спасателям больше нечего делать");
            } else {
                throw new NoOneVictimsException("Все действующие лица улетели в космос и обречены умереть, что за кровожадность автора истории?!");
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

                } else if (s.getPlace() != null) {
                    if (s.getPlace().action(s)) {break;}
                    if (s.getPlace().getNextPlace() != null) {
                        s.goTo(s.getPlace().getNextPlace());
                    }
                }
            } else {
                if (s.getPlace() != null) {
                    if (s.getPlace().action(s)) {break;}
                    if (s.getPlace().getPrevPlace() != null) {
                        s.goTo(s.getPlace().getPrevPlace());
                    }
                }
            }
        }
        if (this.savers.size() == 0) {
            throw new NoOneSaversException("Как жаль, но все спасатели улетели в космос. Жертвы обречены...");
        }
    }

    public void update() throws NoOneVictimsException {
        this.checkVictims();
        this.checkSavers();
    }
}
