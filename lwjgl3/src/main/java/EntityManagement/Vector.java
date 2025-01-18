package EntityManagement;

public class Vector {
    private float x, y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // Add method to update position
    public void add(Vector velocity) {
        this.x += velocity.getX();
        this.y += velocity.getY();
    }
}
