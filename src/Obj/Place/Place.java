package Obj.Place;

import Obj.Grav;
import Obj.MyObject;
import Obj.Person.Saver;

import java.util.concurrent.TransferQueue;


public abstract class Place extends MyObject {
    protected String im, ro, da, vi, tv, pr;
    private Grav grav;
    private Place prevPlace;
    private Place nextPlace;

    public Place(String name, Grav grav) {
        super(name);
        this.grav = grav;
    }

    public Grav getGrav() {
        return grav;
    }

    public void setPadeji(String im, String ro, String da, String vi, String tv, String pr) {
        this.im = im;
        this.ro = ro;
        this.da = da;
        this.vi = vi;
        this.tv = tv;
        this.pr = pr;
    }
    
    public String getPadej(Integer num) {
        return switch (num) {
            case 1 -> this.im;
            case 2 -> this.ro;
            case 3 -> this.da;
            case 4 -> this.vi;
            case 5 -> this.tv;
            case 6 -> this.pr;
            default -> "Нет такого падежа в русском языке";
        };
    }

    public Place getNextPlace() {
        return nextPlace;
    }

    public void setNextPlace(Place nextPlace) {
        this.nextPlace = nextPlace;
    }

    public Place getPrevPlace() {
        return prevPlace;
    }

    public void setPrevPlace(Place prevPlace) {
        this.prevPlace = prevPlace;
    }

    public boolean action(Saver s) {
        return false;
    }
}
