package CollisionManagement;

import EntityManagement.Entity;

public class CollisionManager {
    public boolean checkCollision(Entity entity1, Entity entity2) {
        float distanceX = Math.abs(entity1.getPosition().getX() - entity2.getPosition().getX());
        float distanceY = Math.abs(entity1.getPosition().getY() - entity2.getPosition().getY());

        float combinedWidth = (entity1.getWidth() + entity2.getWidth()) / 2;
        float combinedHeight = (entity1.getHeight() + entity2.getHeight()) / 2;

        return distanceX < combinedWidth && distanceY < combinedHeight;
    }
}
