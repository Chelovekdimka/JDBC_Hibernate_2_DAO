package Ex_02.dao;

import Ex_02.entity.Moon;
import Ex_02.entity.Planet;

import java.util.List;

public interface PlanetDAO {
    void addPlanet(Planet planet);
    void updatePlanet(int id, int starSystem_ID, String name);
    void deletePlanet(int id);
    Planet getPlanetById(int id);
    List<Planet> getAllPlanets();
}
