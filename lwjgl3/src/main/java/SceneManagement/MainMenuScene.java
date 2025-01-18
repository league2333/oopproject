package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenuScene extends Scene {

    @Override
    public void load() {
        // Load menu-specific resources
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        // Render the main menu here
        shapeRenderer.end();
    }

    @Override
    public void update() {
        // Update menu logic here
    }

    @Override
    public void unload() {
        // Unload resources if needed
    }
}
