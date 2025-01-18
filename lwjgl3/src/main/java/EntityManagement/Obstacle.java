package EntityManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Obstacle extends Entity {

    public Obstacle(Vector position, int width, int height) {
        super(position, width, height);
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(1, 0, 0, 1); // Red
        shapeRenderer.rect(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }

    @Override
    public void update() {
        // Logic for updating the obstacle if needed
    }
}
