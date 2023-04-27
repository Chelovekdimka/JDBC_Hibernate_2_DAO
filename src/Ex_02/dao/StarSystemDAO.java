package Ex_02.dao;


import Ex_02.entity.StarSystem;

import java.util.List;

public interface StarSystemDAO {
    void addStarSystem(StarSystem starSystem);
    void updateStarSystem(int id, String name);
    void deleteStarSystem(int id);
    StarSystem getStarSystemById(int id);
    List<StarSystem> getAllStarSystems();
}
