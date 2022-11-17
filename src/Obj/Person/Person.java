package Obj.Person;

import Obj.MyObject;
import Obj.Place.Place;

public abstract class Person extends MyObject {
    protected Place place;

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public Person(String name) {
        super(name);
    }
}
