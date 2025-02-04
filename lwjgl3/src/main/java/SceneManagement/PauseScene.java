package SceneManagement;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class PauseScene extends Scene {
    private Texture pauseMenuTexture;

    public PauseScene() {
        // Initialize the pause menu texture (replace with your actual pause menu image path)
        pauseMenuTexture = new Texture("pause_menu.png");
    }

    @Override
    public void load() {
        // Load pause-specific resources if needed
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();

        // Render the pause menu (this assumes you're rendering a texture for the pause menu)
        batch.draw(pauseMenuTexture, 0, 0);

        batch.end();
    }

    @Override
    public void update() {
        // Update pause logic here (e.g., input handling, menu navigation)
    }

    @Override
    public void unload() {
        // Unload pause-specific resources if needed
    }

    @Override
    public void dispose() {
        unload();
        pauseMenuTexture.dispose(); // Dispose of the texture to free up memory
    }
}
