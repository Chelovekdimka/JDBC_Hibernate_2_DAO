package Ex_02;

import Ex_02.dao.*;
import Ex_02.entity.Moon;
import Ex_02.entity.Planet;
import Ex_02.entity.StarSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();

        StarSystemDAO ssDAO = factory.getStarSystemDAO();
        List<StarSystem> starSystems = ssDAO.getAllStarSystems();
        for (StarSystem ss : starSystems) {
            System.out.println(ss.getId() + " " + ss.getName());
        }
        System.out.println();

        PlanetDAO planetDAO = factory.getPlanetDAO();
        List<Planet> planets = planetDAO.getAllPlanets();
        for (Planet p : planets) {
            System.out.println(p.getId() + " " + p.getStarsystem_ID() + " " + p.getName());
        }
        System.out.println();

        MoonDAO moonDAO = factory.getMoonDAO();
        List<Moon> moons = moonDAO.getAllMoons();
        for (Moon m : moons) {
            System.out.println(m.getId() + " " + m.getPlanet_ID() + " " + m.getName());
        }
        System.out.println();
//        Для перевірки виконання розблокувати:
//        StarSystem starSystem1 = new StarSystem("Veritate");
//        ssDAO.addStarSystem(starSystem1);

        StarSystem starSystemById = ssDAO.getStarSystemById(3);
        System.out.println(starSystemById.getName());


//        ssDAO.updateStarSystem(3, "Alpheratz");

//        ssDAO.deleteStarSystem(3);














    }
}