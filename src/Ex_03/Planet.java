package Ex_03;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private String name;
    private List<Moon> moons;

    public Planet(String name) {
        this.name = name;
        this.moons = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public List<Moon> getMoons() {
        return this.moons;
    }

    public void addMoon(Moon moon) {
        this.moons.add(moon);
    }
}
