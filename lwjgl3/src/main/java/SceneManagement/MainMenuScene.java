package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MainMenuScene extends Scene {

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        
        // Draw "Start Game" button or any other menu elements
        shapeRenderer.rect(200, 150, 400, 100); // Example button (could be a rectangle)

        shapeRenderer.end();
    }

    @Override
    public void load() {
        // Load resources for the Main Menu
    }

    @Override
    public void unload() {
        // Clean up resources for the Main Menu
    }

    @Override
    public void update() {
        // Check for user input (for example, clicking a "Start Game" button)
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            // Switch to the Game Scene when ENTER is pressed
            SceneManager.getInstance().switchScene("Game");
        }
    }
}
