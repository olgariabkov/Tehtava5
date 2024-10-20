package Tehtava4.DinoType;

import Tehtava4.Dinosaur;

public class FlyingDinosaur extends Dinosaur {
    private boolean hasFeathers;

    //konstruktori

    public FlyingDinosaur(String name, int age, String species, boolean hasFeathers) {
        super(name, age, species); //kutsutaan yliluokan konstruktoria
        this.hasFeathers = hasFeathers;
    }

    //getterr ja setter

    public boolean isHasFeathers() {
        return hasFeathers;
    }

    public void setHasFeathers(boolean hasFeathers) {
        this.hasFeathers = hasFeathers;
    }

    @Override
    public String toString() {
        return "FlyingDinosaur{" +
                "hasFeathers=" + hasFeathers +
                '}';
    }
}

