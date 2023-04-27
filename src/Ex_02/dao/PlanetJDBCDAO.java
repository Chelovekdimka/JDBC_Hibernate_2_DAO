package Ex_02.dao;

import Ex_02.entity.Moon;
import Ex_02.entity.Planet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetJDBCDAO implements PlanetDAO{
    Connection connection = getConnection();
    @Override
    public void addPlanet(Planet planet) {
        String sql = "INSERT INTO Planet (starsystem_ID, name) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, planet.getStarsystem_ID());
            statement.setString(2, planet.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                planet.setId(id);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding planet", e);
        }
    }


    @Override
    public void updatePlanet(int id, int starSystem_ID, String name) {
        String sql = "UPDATE Planet SET starsystem_ID = ?, name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(3, id);
            statement.setInt(1, starSystem_ID);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating planets", e);
        }
    }

    @Override
    public void deletePlanet(int id) {
        String sql = "DELETE FROM Planet WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting planet", e);
        }
    }

    @Override
    public Planet getPlanetById(int id) {
        String sql = "SELECT * FROM Planet WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Planet planet = new Planet(name);
                planet.setId(id);
                return planet;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting planet", e);
        }
    }

    @Override
    public List<Planet> getAllPlanets() {
        List<Planet> planets = new ArrayList<>();
        String sql = "SELECT * FROM Planet";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int starSystem_Id = rs.getInt("starsystem_ID");
                String name = rs.getString("name");
                Planet planet = new Planet(name);
                planet.setId(id);
                planet.setStarSystem_ID(starSystem_Id);
                planets.add(planet);
            }
            return planets;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting planets", e);
        }
    }
    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StarSystemDB", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
