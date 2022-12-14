package Obj.Story;

import Obj.CustomException.NoOneVictimsException;
import Obj.Grav;
import Obj.Lobby.Lobby;
import Obj.Person.Victim;
import Obj.Person.Saver;
import Obj.Place.Crater;
import Obj.Place.FarAway;
import Obj.Place.Field;
import Obj.Place.Zabor;
import Obj.SayHelloToUser;

public class Story {
    // Герои
    Saver saver = new Saver("Знайка");
    Saver saver2 = new Saver("Незнайка");
    Victim victim = new Victim("Винтик");
    Victim victim2 = new Victim("Шпунтик");
    Victim victim3 = new Victim("Гунтик");

    // Локации
    Crater crater = new Crater("кратер", Grav.STRONG);
    Zabor zabor = new Zabor("забор", Grav.STRONG);
    Field field = new Field("поле", Grav.WEAK);
    FarAway farAway = new FarAway("даль", Grav.NO);

    // Лобби
    Lobby lobby = new Lobby(this);

    boolean running = true;

    public Story() {
        // Анонимный мистер вежливый бот
        SayHelloToUser mrPoliteBot = new SayHelloToUser() {
            @Override
            public void sayHello() {
                System.out.println("Привет наш дорогой и многоуважаемый пользователь");
            }
        };

        mrPoliteBot.sayHello();
        SayHelloAgain.say();
        SayHelloAgainAgain aaa = new SayHelloAgainAgain();
        aaa.say();
        PoliteAndFriendly.say();
        PoliteAndFriendly politebot = new PoliteAndFriendly();
        politebot.notFriendly();

        crater.setPadeji("кратер", "кратера", "кратеру", "кратер", "кратером", "кратере");
        zabor.setPadeji("забор", "забора", "забору", "забор", "забором", "заборе");
        field.setPadeji("поле", "поля", "полю", "поле", "полем", "поле");
        farAway.setPadeji("даль", "дали", "дали", "даль", "далью", "дали");

        lobby.setLocations(farAway, field, zabor, crater);
//        lobby.setSaver(saver, saver2);
        lobby.setSaver(saver);
        lobby.setVictims(victim, victim2, victim3);

        victim.setPlace(crater);
        victim2.setPlace(crater);
        victim3.setPlace(crater);
        saver.setPlace(farAway);
//        saver2.setPlace(farAway);

        farAway.setNextPlace(field);
        field.setPrevPlace(farAway);
        field.setNextPlace(zabor);
        zabor.setPrevPlace(field);
        zabor.setNextPlace(crater);
        crater.setPrevPlace(zabor);
    }

    public void chapter1() {
        while (running) {
            try {

                lobby.update();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println(e);
                running = false;
            }
        }
        System.out.println("История закончилась, попробуйте написать другую");
    }

    public void setRunning(boolean st) {
        this.running = st;
    }

    public static class SayHelloAgain {
        public static void say() {
            System.out.println("ПРИВЕТ ПРИВЕТ!");
        }
    }

    public class SayHelloAgainAgain {
        public void say() {
            System.out.println("ЗДРАВСТВУЙТЕ, HALLO, HELLO, HI, ПРИВЕТ, КУ, АЛОХА, GOOD MORNING");
        }
    }
}


class PoliteAndFriendly {
    public static void say() {
        System.out.println("Im very very polite and friendly, and say hello");
    }

    public void notFriendly() {
        System.out.println("Im very very not polite and not friendly, and not say hello");
    }
}