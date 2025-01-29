package EntityManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Entity {
    private Vector position;
    private int width;
    private int height;
    private Vector velocity;  // Add the velocity field

    public Entity(Vector position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.velocity = new Vector(0, 0); // Initialize velocity
    }

    public abstract void render(ShapeRenderer shapeRenderer);
    public abstract void update();

    // Getters and Setters
    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Add the getVelocity() and setVelocity(Vector) methods
    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
