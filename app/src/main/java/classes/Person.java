package classes;


import java.util.ArrayList;

public class Person {
    Info info;
    ArrayList<Classes> classes;

    public Info getInfo() {
        return info;
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void setClasses(Classes classes) {
        this.classes.add(classes);
    }
}
