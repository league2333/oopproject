package InputOutputManagement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;
import EntityManagement.Player;
import EntityManagement.Vector;

public class InputManager {

    public void processInput(Player player) {
        Vector velocity = new Vector(0, 0); // Default velocity

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.setY(1); // Move up
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.setY(-1); // Move down
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.setX(-1); // Move left
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.setX(1); // Move right
        }

        player.setVelocity(velocity); // Update player velocity based on input
    }
}
