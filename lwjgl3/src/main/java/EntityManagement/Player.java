package EntityManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player extends Entity {

    public Player(Vector position, int width, int height) {
        super(position, width, height);
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(1, 1, 0, 1); // Yellow
        shapeRenderer.rect(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }

    @Override
    public void update() {
        // Logic for updating the player position, health, etc.
        // Example: Update position based on velocity
        getPosition().add(getVelocity());
    }
}
