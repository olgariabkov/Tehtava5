package Tehtava4.DinoType;

import Tehtava4.Dinosaur;

public class AquaticDinosaur extends Dinosaur {
    private boolean canSwim;

    // konstruktori

    public AquaticDinosaur(String name, int age, String species, boolean canSwim) {
        super(name, age, species);
        this.canSwim = canSwim;
    }

    //getter ja setter

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    @Override
    public String toString() {
        return "AquaticDinosaur{" +
                "canSwim=" + canSwim +
                '}';
    }
}
