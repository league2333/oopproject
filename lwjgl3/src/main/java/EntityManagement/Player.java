package EntityManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float width = 10;
    private float height = 20;

    // Animation variables
    private float armAngle = 0;
    private float legAngle = 0;
    private float animationSpeed = 10f;
    private float stateTime = 0;

    // Boundary detection
    private float minX, maxX, minY, maxY;

    public Player(Vector2 position, float minX, float maxX, float minY, float maxY) {
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public void update(float deltaTime) {
        // Update position with boundary check
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        position.x = MathUtils.clamp(position.x, minX, maxX - width);
        position.y = MathUtils.clamp(position.y, minY, maxY - height);

        // Update limb angles when moving
        if (velocity.len() > 0) {
            armAngle = MathUtils.sinDeg(stateTime * animationSpeed) * 4;
            legAngle = -MathUtils.sinDeg(stateTime * animationSpeed) * 8; // Opposite direction
        } else {
            armAngle = legAngle = 0;
        }

        stateTime += deltaTime * animationSpeed;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(1, 1, 1, 1);

        // Body (vertical line)
        shapeRenderer.rectLine(position.x, position.y, position.x, position.y + height, 2);

        // Arms with improved movement
        shapeRenderer.rectLine(
            position.x, position.y + height/2,
            position.x - width/2 + armAngle, 
            position.y + height/2 + Math.abs(armAngle) * 0.5f,  
            2
        );
        shapeRenderer.rectLine(
            position.x, position.y + height/2,
            position.x + width/2 - armAngle,
            position.y + height/2 + Math.abs(armAngle) * 0.5f,
            2
        );

        // Legs with improved movement
        shapeRenderer.rectLine(
            position.x, position.y,
            position.x - width/2 + legAngle,
            position.y - height/2 - Math.abs(legAngle) * 0.5f,
            2
        );
        shapeRenderer.rectLine(
            position.x, position.y,
            position.x + width/2 - legAngle,
            position.y - height/2 - Math.abs(legAngle) * 0.5f,
            2
        );

        // Head (circle above the body)
        shapeRenderer.circle(position.x, position.y + height + 10, 10);
    }

    public void moveLeft() {
        velocity.x = -100; // Move left
    }

    public void moveRight() {
        velocity.x = 100; // Move right
    }

    public void moveUp() {
        velocity.y = 100; // Move up
    }

    public void moveDown() {
        velocity.y = -100; // Move down
    }

    public void stopMoving() {
        velocity.set(0, 0); // Stop moving
    }

    public Vector2 getPosition() {
        return position;
    }

    public void dispose() {
        // No resources to dispose for now
    }
}
