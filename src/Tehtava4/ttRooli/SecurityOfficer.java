package Tehtava4.ttRooli;

import Tehtava4.Employee;

public class SecurityOfficer extends Employee {

    private boolean hasGunLicence;

    //konstruktori

    public SecurityOfficer(String name, String jobTitle, int yearsOfExperience, boolean hasGunLicence) {
        super(name, jobTitle, yearsOfExperience);
        this.hasGunLicence = hasGunLicence;
    }

    //getter ja setter

    public boolean isHasGunLicence() {
        return hasGunLicence;
    }

    public void setHasGunLicence(boolean hasGunLicence) {
        this.hasGunLicence = hasGunLicence;
    }

    @Override
    public String toString() {
        return "SecurityOfficer{" +
                "hasGunLicence=" + hasGunLicence +
                '}';
    }
}
