package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PauseScene extends Scene {

    @Override
    public void load() {
        // Load pause-specific resources
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Render the pause menu here
        shapeRenderer.end();
    }

    @Override
    public void update() {
        // Update pause logic here
    }

    @Override
    public void unload() {
        // Unload resources if needed
    }
}
