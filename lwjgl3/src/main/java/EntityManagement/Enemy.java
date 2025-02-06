package EntityManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Enemy extends Entity {
    private com.badlogic.gdx.math.Vector2 velocity;
    private int width, height;

    public Enemy(Vector position, int width, int height) {
        super(position, width, height);
        this.width = width;
        this.height = height;

        // Set a random speed between 50 and 150 pixels per second in a random direction.
        float speed = MathUtils.random(50, 150);
        float angle = MathUtils.random(0, 360);
        this.velocity = new com.badlogic.gdx.math.Vector2(speed * MathUtils.cosDeg(angle), speed * MathUtils.sinDeg(angle));
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
  //      shapeRenderer.begin(ShapeRenderer.ShapeType.Filled); // Begin rendering

        // Set enemy color to red.
        shapeRenderer.setColor(Color.RED);

        // Define parameters for a spiky star shape.
        int numPoints = 8;                    // Number of spikes
        float outerRadius = width / 2f;        // Outer radius for spikes
        float innerRadius = outerRadius / 2f;  // Inner radius for in-between points

        float centerX = getPosition().getX() + width / 2f;
        float centerY = getPosition().getY() + height / 2f;

        float[] vertices = new float[(numPoints + 1) * 2]; // Store (x, y) coordinates

        for (int i = 0; i < numPoints; i++) {
            float angle = i * MathUtils.PI2 / numPoints;
            float radius = (i % 2 == 0) ? outerRadius : innerRadius;
            vertices[i * 2] = centerX + MathUtils.cos(angle) * radius;
            vertices[i * 2 + 1] = centerY + MathUtils.sin(angle) * radius;
        }

        // Draw spikes using triangles
        for (int i = 0; i < numPoints; i++) {
            int next = (i + 1) % numPoints;
            shapeRenderer.triangle(
                    centerX, centerY,  // Triangle center
                    vertices[i * 2], vertices[i * 2 + 1],   // Current vertex
                    vertices[next * 2], vertices[next * 2 + 1] // Next vertex
            );
        }

        // Draw eyes as black filled circles
        shapeRenderer.setColor(Color.BLACK);
        float eyeSize = width * 0.1f;
        shapeRenderer.circle(centerX - eyeSize * 2, centerY - 2 + eyeSize, eyeSize); // Left eye
        shapeRenderer.circle(centerX + eyeSize * 2, centerY - 2 + eyeSize, eyeSize); // Right eye

//        shapeRenderer.end(); // End rendering
    }

    @Override
    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        getPosition().add(new Vector(velocity.x * deltaTime, velocity.y * deltaTime));

        // Wall Collision Handling with 20px Margin
        int margin = 20;
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        if (getPosition().getX() < margin || getPosition().getX() + width > screenWidth - margin) {
            velocity.x = -velocity.x;
        }
        if (getPosition().getY() < margin || getPosition().getY() + height > screenHeight - margin) {
            velocity.y = -velocity.y;
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
