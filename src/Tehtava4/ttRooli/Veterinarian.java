package Tehtava4.ttRooli;

import Tehtava4.Employee;

public class Veterinarian extends Employee {

    private String specialization;

    //konstruktori

    public Veterinarian(String name, String jobTitle, int yearsOfExperience, String specialization) {
        super(name, jobTitle, yearsOfExperience);
        this.specialization = specialization;
    }

    //getter ja setter

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
