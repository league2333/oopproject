package EntityManagement;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void updateEntities() {
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }
}
