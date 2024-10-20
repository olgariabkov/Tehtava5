package Tehtava4;

import Tehtava4.DinoType.AquaticDinosaur;
import Tehtava4.DinoType.FlyingDinosaur;
import Tehtava4.DinoType.LandDinosaur;
import Tehtava4.ttRooli.ParkManager;
import Tehtava4.ttRooli.SecurityOfficer;
import Tehtava4.ttRooli.Veterinarian;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App2 {


    public static void main(String[] args) throws FileNotFoundException {


        //luodaan uusi Park objekkti nimellä D...
        Park park = new Park("Dinosaur Park in TUAS");

        //System.out.println(park);

        //luodaan dinosauruksia
        Dinosaur dino1 = new Dinosaur("T-Rex", 12, "Carnivore");
        Dinosaur dino2 = new Dinosaur("Velociraptor", 7, "Carnivore");
        Dinosaur dino3 = new Dinosaur("Triceratops", 15, "Herbivore");

        FlyingDinosaur flyingDino = new FlyingDinosaur("Pterodactyl", 5, "Flying", true);
        AquaticDinosaur aquaticDino = new AquaticDinosaur("Mosasaurus", 7, "Aquatic", true);
        LandDinosaur landDino = new LandDinosaur("T-Rex", 15, "Land", true);

        //lisätään dinoja
        park.addDinosaur(flyingDino);
        park.addDinosaur(aquaticDino);
        park.addDinosaur(landDino);

        System.out.println("The program start reeding");


        // read the files for employees and for dinosaurs
        park.readEmployeesFromFile();
        //System.out.println(park);
        park.readDinosaursFromFile();
        //tulostetaan park objekti
        System.out.println(park);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //toistuu kunnes käyttäjä haluaa poistua
        while (!exit) {
            //näytetään valikko
            displayMenu(park.getName());
            //käyttäjän valinta
            int choice = scanner.nextInt();
            scanner.nextLine();
            //käsitellään käyttäjän valinta
            handleMenuChoice(choice, park, scanner);
        }
    }

    //metodi näyttää päävalikon
    public static void displayMenu(String parkName) {
        System.out.println("\n\nWelcome to *** " + parkName + " ***");
        System.out.println("1. Mange Dinosaur");
        System.out.println("2. Mange Park Employees");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
    }

    //metodi käsittelee valinnan valikossa
    public static void handleMenuChoice(int choice, Park park, Scanner scanner) {
        switch (choice) {
            case 1:
                manageDinosaurs(park, scanner);
                break;
            case 2:
                manageEmployees(park, scanner);
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }

    //metodi käsittelee työntekijöiden hallinnan
    public static void manageEmployees(Park park, Scanner scanner) {
        //tulostetaan kaikki työntekijät
        System.out.println("All park employees: ");
        System.out.println(park.getEmployees());

        System.out.println("a(dd) - r(emove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                //lisätään uusi tt
                Employee e = askEmployeeInfo(scanner);
                park.getEmployees().add(e);
                break;
            case 'r':
                //poistetaan tt
                System.out.println("Enter the employee index to remove: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 0 && index < park.getEmployees().size()) {
                    park.getEmployees().remove(index);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'u':
                System.out.println("Enter the employee index to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                if (updateIndex >= 0 && updateIndex < park.getEmployees().size()) {
                    updateEmployeeInfo(park.getEmployees().get(updateIndex), scanner);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'c':
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    //kysytään tt tiedot
    public static Employee askEmployeeInfo(Scanner scanner) {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter job title: ");
        String jobTitle = scanner.nextLine();
        System.out.println("Enter years of experience: ");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        //valitaan tt rooli
        System.out.println("Is the employee a Park manager? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Enter bonus: ");
            double bonus = scanner.nextDouble();
            scanner.nextLine();
            return new ParkManager(name, jobTitle, yearsOfExperience, bonus);
    }

        System.out.println("Is the employee a Secutity Officer? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Does the emloyee have a gun license? (y/n)");
            boolean hasGunLicense = scanner.nextLine().equalsIgnoreCase("y");
            return new SecurityOfficer(name, jobTitle, yearsOfExperience, hasGunLicense);
    }

        System.out.println("is the employee a Veterinarian? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Enter veterinarian specialization: ");
            String specialization = scanner.nextLine();
            return new Veterinarian(name, jobTitle, yearsOfExperience, specialization);
        }

        return new Employee(name, jobTitle, yearsOfExperience);
        }

    public static void updateEmployeeInfo(Employee employee, Scanner scanner) {
        System.out.println("Updating employee: " + employee);
        System.out.println("Enter new job title: ");
        String newJobTitle = scanner.nextLine();
        System.out.println("Enter new years of experience: ");
        int newYearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        employee.setJobTitle(newJobTitle);
        employee.setYearsOfExperience(newYearsOfExperience);

        System.out.println("Employee updated: " + employee);
    }

    public static void manageDinosaurs(Park park, Scanner scanner) {
        System.out.println("All dinosaurs: ");
        System.out.println(park.getDinosaurs());

        System.out.println("a(dd) - r(remove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                //lisätään uusi dino
                Dinosaur d = askDinosaurInfo(scanner);
                park.addDinosaur(d);
                break;
            case 'r':
                //poistetaan dino
                System.out.println("Enter the dinosaur index to remove: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 0 && index < park.getDinosaurs().size()) {
                    park.removeDinosaur(index);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'u':
                System.out.println("Enter the dinosaur index to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                if (updateIndex >= 0 && updateIndex < park.getDinosaurs().size()) {
                    updateDinoInfo(park.getDinosaurs().get(updateIndex), scanner);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'c':
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void updateDinoInfo(Dinosaur dinosaurs, Scanner scanner) {
        System.out.println("Updating dino: " + dinosaurs);
        System.out.println("Enter new years of experience: ");
        int newAge = scanner.nextInt();
        System.out.println("Enter new job title: ");
        String newSpecies = scanner.nextLine();
        scanner.nextLine();

        dinosaurs.setAge(newAge);
        dinosaurs.setSpecies(newSpecies);

        System.out.println("Dino updated: " + dinosaurs);
        //jos tyyppi ei ole valittu
    }

    //metodi uusi dino tiedot
    public static Dinosaur askDinosaurInfo(Scanner scanner) {
        System.out.println("Enter dinosaur name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the dinosaur age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter dinosaur species: ");
        String species = scanner.nextLine();

        System.out.println("Is this a flying dinosaur? (y/n)");
        boolean isFlying = scanner.nextLine().equalsIgnoreCase("y");

        if (isFlying) {
            System.out.println("Does it have feathers? (y/n)");
            boolean hasFeathers = scanner.nextLine().equalsIgnoreCase("y");
            return new FlyingDinosaur(name, age, species, hasFeathers);
        }

        System.out.println("Is this an aquatic dinosaur? (y/n)");
        boolean isAquatic = scanner.nextLine().equalsIgnoreCase("y");

        if (isAquatic) {
            System.out.println("can it swim? (y/n)");
            boolean canSwim = scanner.nextLine().equalsIgnoreCase("y");
            return new AquaticDinosaur(name, age, species, canSwim);
        }

        System.out.println("Is this a land dinosaur? (y/n)");
        boolean isLand = scanner.nextLine().equalsIgnoreCase("y");

        if (isLand) {
            System.out.println("Is it a predator? (y/n)");
            boolean isPredator = scanner.nextLine().equalsIgnoreCase("y");
            return new LandDinosaur(name, age, species, isPredator);
        }

        return null;
    }
}
