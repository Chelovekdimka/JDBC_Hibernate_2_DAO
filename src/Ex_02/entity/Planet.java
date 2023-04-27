package Ex_02.entity;

public class Planet {
    private int id;
    private int starsystem_ID;
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getStarsystem_ID() {
        return starsystem_ID;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStarSystem_ID(int starSystem_ID) {
        this.starsystem_ID = starSystem_ID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
