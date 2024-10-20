package Tehtava4.DinoType;

import Tehtava4.Dinosaur;

public class LandDinosaur extends Dinosaur {
    private boolean isPredator;

    //konstruktori

    public LandDinosaur(String name, int age, String species, boolean isPredator) {
        super(name, age, species);
        this.isPredator = isPredator;
    }

    //getter ja setter

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public String toString() {
        return "LandDinosaur{" +
                "isPredator=" + isPredator +
                '}';
    }
}
