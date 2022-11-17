import Obj.Grav;
import Obj.Lobby.Lobby;
import Obj.Person.Victim;
import Obj.Person.Saver;
import Obj.Place.Crater;
import Obj.Place.FarAway;
import Obj.Place.Field;
import Obj.Place.Zabor;

public class Story {
    // Герои
    Saver saver = new Saver("Знайка");
    Victim victim = new Victim("Винтик");
    Victim victim2 = new Victim("Шпунтик");
    Victim victim3 = new Victim("Гунтик");

    // Локации
    Crater crater = new Crater("кратер", Grav.STRONG);
    Zabor zabor = new Zabor("забор", Grav.STRONG);
    Field field = new Field("поле", Grav.WEAK);
    FarAway farAway = new FarAway("даль", Grav.NO);

    // Лобби
    Lobby lobby = new Lobby();

    public Story() {
        crater.setPadeji("кратер", "кратера", "кратеру", "кратер", "кратером", "кратере");
        zabor.setPadeji("забор", "забора", "забору", "забор", "забором", "заборе");
        field.setPadeji("поле", "поля", "полю", "поле", "полем", "поле");
        farAway.setPadeji("даль", "дали", "дали", "даль", "далью", "дали");

        lobby.setLocations(farAway, field, zabor, crater);
        lobby.setSaver(saver);
        lobby.setVictims(victim, victim2, victim3);

        victim.setPlace(crater);
        victim2.setPlace(crater);
        victim3.setPlace(crater);
        saver.setPlace(farAway);
    }

    public void chapter1() {
        while (true) {
            lobby.update();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
