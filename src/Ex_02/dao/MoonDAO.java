package Ex_02.dao;

import Ex_02.entity.Moon;
import Ex_02.entity.StarSystem;

import java.util.List;

public interface MoonDAO {
    void addMoon(Moon moon);
    void updateMoon(int id, int planet_ID, String name);
    void deleteMoon(int id);
    Moon getMoonById(int id);
    List<Moon> getAllMoons();
}
