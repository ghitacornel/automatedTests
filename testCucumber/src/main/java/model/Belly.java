package model;

public class Belly {

    private int cakes = 0;

    public void eat(int cakes) {
        this.cakes += cakes;
    }

    public int getCakesInBelly() {
        return cakes;
    }

    public void growl() {
        System.out.println("growl " + cakes);
    }

    public void wait(int hours) {
        System.out.println("waiting " + hours + " hours");
    }
}
