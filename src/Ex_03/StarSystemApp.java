package Ex_03;

import java.util.Scanner;

public class StarSystemApp {
    public StarSystemApp() {
    }

    public static void main(String[] args) {
        StarSystem starSystem = new StarSystem("Solar System");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while(true) {
            while(!quit) {
                System.out.println("Choose an option:");
                System.out.println("1. Print name of star system");
                System.out.println("2. Add planet");
                System.out.println("3. Print number of planets");
                System.out.println("4. Quit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Name of star system: " + starSystem.getName());
                        break;
                    case 2:
                        System.out.print("Enter name of planet: ");
                        String planetName = scanner.next();
                        System.out.print("Enter number of moons: ");
                        int numMoons = scanner.nextInt();
                        Planet planet = new Planet(planetName);

                        for(int i = 0; i < numMoons; ++i) {
                            System.out.print("Enter name of moon " + (i + 1) + ": ");
                            String moonName = scanner.next();
                            planet.addMoon(new Moon(moonName));
                        }

                        starSystem.addPlanet(planet);
                        System.out.println("Planet added to system.");
                        break;
                    case 3:
                        System.out.println("Number of planets: " + starSystem.getPlanets().size());
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

            return;
        }
    }
}
