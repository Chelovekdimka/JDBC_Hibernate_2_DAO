package Ex_02.entity;

public class Moon {
    private int id;
    private int planet_ID;
    private String name;

    public Moon(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPlanet_ID() {
        return planet_ID;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlanet_ID(int planet_ID) {
        this.planet_ID = planet_ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
