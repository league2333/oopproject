package MovementManagement;

import EntityManagement.Entity;
import EntityManagement.Vector;

public class MovementManager {
    public void updatePosition(Entity entity) {
        Vector currentPosition = entity.getPosition();
        Vector velocity = entity.getVelocity();
        currentPosition.add(velocity);
        entity.setPosition(currentPosition);
    }
}
