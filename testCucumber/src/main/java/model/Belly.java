package model;

public class Belly {

    private int cukes = 0;

    public void eat(int cukes) {
        this.cukes += cukes;
    }

    public int getCukes() {
        return cukes;
    }

    public void growl() {
        System.out.println("growl " + cukes);
    }

    public void wait(int hours) {
        System.out.println("waiting " + hours + " hours");
    }
}
