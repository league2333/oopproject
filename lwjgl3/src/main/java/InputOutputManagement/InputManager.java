package InputOutputManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import SceneManagement.SceneManager;
import SceneManagement.GameScene;
import SceneManagement.PauseScene;
import EntityManagement.Player;

public class InputManager {

    // Flag to track if the game is paused
    private boolean isPaused = false;

    public void processInput(Player player) {
        // Check for 'P' key press to toggle pause
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            togglePause();
        }

        if (!isPaused) { // Don't process movement input when the game is paused
            // Handle movement input when the game is not paused
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                player.moveLeft();
            } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                player.moveRight();
            } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                player.moveUp();
            } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                player.moveDown();
            } else {
                player.stopMoving();
            }
        }
    }

    private void togglePause() {
        if (isPaused) {
            // If the game is paused, resume the game by switching to GameScene
            SceneManager.getInstance().switchScene("Game");
        } else {
            // If the game is not paused, pause the game by switching to PauseScene
            SceneManager.getInstance().switchScene("Pause");
        }
        isPaused = !isPaused;
    }
}
