package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import EntityManagement.Vector;

public class GameScene extends Scene {

    private Vector position;
    private int width = 100;
    private int height = 100;

    public GameScene() {
        position = new Vector(50, 50); // Example starting position
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        // Always ensure begin() is paired with end()
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Ensure no other begin() calls are made here before end() is called
        shapeRenderer.rect(position.getX(), position.getY(), width, height);  // Render rectangle based on Vector

        shapeRenderer.end();  // Always call end() to complete the batch
    }

    @Override
    public void load() {
        // Load resources or prepare scene
    }

    @Override
    public void unload() {
        // Clean up resources if needed
    }

    @Override
    public void update() {
        // Update logic for the Game Scene
    }
}