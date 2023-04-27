package Ex_02.dao;

import Ex_02.entity.StarSystem;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StarSystemJDBCDAO implements StarSystemDAO {

    Connection connection = getConnection();

    @Override
    public void addStarSystem(StarSystem starSystem) {
        String sql = "INSERT INTO Starsystem (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, starSystem.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                starSystem.setId(id);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding star system", e);
        }
    }

    @Override
    public void updateStarSystem(int id, String name) {
        String sql = "UPDATE Starsystem SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating star system", e);
        }
    }

    @Override
    public void deleteStarSystem(int id) {
        String sql = "DELETE FROM Starsystem WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting star system", e);
        }
    }

    @Override
    public StarSystem getStarSystemById(int id) {
        String sql = "SELECT * FROM StarSystem WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                StarSystem starSystem = new StarSystem(name);
                starSystem.setId(id);
                return starSystem;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting star system", e);
        }
    }

    @Override
    public List<StarSystem> getAllStarSystems() {
        List<StarSystem> starSystems = new ArrayList<>();
        String sql = "SELECT * FROM StarSystem";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                StarSystem starSystem = new StarSystem(name);
                starSystem.setId(id);
                starSystems.add(starSystem);
            }
            return starSystems;
        } catch (SQLException e) {
            throw new RuntimeException("Error getting star systems", e);
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