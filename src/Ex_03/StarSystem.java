package Ex_03;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private String name;
    private List<Planet> planets;

    public StarSystem(String name) {
        this.name = name;
        this.planets = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public List<Planet> getPlanets() {
        return this.planets;
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }
}