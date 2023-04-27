package Ex_02.dao;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized IDAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }


    @Override
    public StarSystemDAO getStarSystemDAO() {
        return new StarSystemJDBCDAO();
    }

    @Override
    public PlanetDAO getPlanetDAO() {
        return new PlanetJDBCDAO();
    }

    @Override
    public MoonDAO getMoonDAO() {
        return new MoonJDBCDAO();
    }
}