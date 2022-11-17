package Obj;

public abstract class MyObject {
    protected String name;
    protected Integer true_hashcode;

    public MyObject(String name) {
        this.name = name;
        this.true_hashcode = super.hashCode();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return this.hashCode() == myObject.hashCode();
    }

    @Override
    public int hashCode() {
        /*
        int psevdo_hash = 0;

        for (int i = 0; i < name.length(); ++i) {
            psevdo_hash += name.charAt(i);
        }

        return psevdo_hash;
        */

        return true_hashcode;
    }

    @Override
    public String toString() {
        return name;
    }
}
