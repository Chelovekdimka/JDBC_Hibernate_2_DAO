package Ex_02.dao;


public interface IDAOFactory {
    StarSystemDAO getStarSystemDAO();
    PlanetDAO getPlanetDAO();

    MoonDAO getMoonDAO();
}
