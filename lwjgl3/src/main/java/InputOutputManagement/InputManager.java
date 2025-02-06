package InputOutputManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import EntityManagement.Player;

public class InputManager {
    public void processInput(Player player) {
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