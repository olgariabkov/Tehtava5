package Tehtava4.ttRooli;

import Tehtava4.Employee;

public class ParkManager extends Employee {

    private double bonus;

    //konstruktori

    public ParkManager(String name, String jobTitle, int yearsOfExperience, double bonus) {
        super(name, jobTitle, yearsOfExperience);
        this.bonus = bonus;
    }

    //getter ja setter

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "ParkManager{" +
                "bonus=" + bonus +
                '}';
    }
}


