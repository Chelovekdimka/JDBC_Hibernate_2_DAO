package Ex_02.dao;

import Ex_02.entity.Moon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoonJDBCDAO implements MoonDAO{
    Connection connection = getConnection();
    @Override
    public void addMoon(Moon moon) {
        String sql = "INSERT INTO Moon (planet_ID, name) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, moon.getPlanet_ID());
            statement.setString(2, moon.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                moon.setId(id);

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding moon", e);
        }
    }

    @Override
    public void updateMoon(int id, int planet_ID, String name) {
        String sql = "UPDATE Moon SET planet_ID = ?, name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, planet_ID);
            statement.setInt(3, id);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating moons", e);
        }
    }

    @Override
    public void deleteMoon(int id) {
        String sql = "DELETE FROM Moon WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting moon", e);
        }
    }

    @Override
    public Moon getMoonById(int id) {
        String sql = "SELECT * FROM Moon WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Moon moon = new Moon(name);
                moon.setId(id);
                return moon;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting moon", e);
        }
    }

    @Override
    public List<Moon> getAllMoons() {
            List<Moon> moons = new ArrayList<>();
            String sql = "SELECT * FROM Moon";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int planet_Id = rs.getInt("planet_ID");
                    String name = rs.getString("name");
                    Moon moon = new Moon(name);
                    moon.setId(id);
                    moon.setPlanet_ID(planet_Id);
                    moons.add(moon);
                }
                return moons;
            } catch (SQLException e) {
                throw new RuntimeException("Error getting moons", e);
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
