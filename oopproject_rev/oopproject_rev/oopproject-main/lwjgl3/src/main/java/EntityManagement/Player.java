package EntityManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {

    private Vector position;
    private int width = 50;
    private int height = 50;
    private Vector velocity;

    public Player(Vector position) {
        this.position = position;
        this.velocity = new Vector(0, 0);
    }

    public void update() {
        // Update position based on velocity
        position.add(velocity);
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(1, 1, 0, 1); // Yellow
        shapeRenderer.rect(position.getX(), position.getY(), width, height); // Render player as a rectangle
    }

    public Vector getPosition() {
        return position;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void stop() {
        this.velocity = new Vector(0, 0);
    }
}
