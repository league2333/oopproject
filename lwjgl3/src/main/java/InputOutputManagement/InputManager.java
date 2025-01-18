package InputOutputManagement;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Gdx;
import EntityManagement.Player;
import EntityManagement.Vector;

public class InputManager {

    public void processInput(Player player) {
        Vector velocity = new Vector(0, 0);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.setY(1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.setY(-1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.setX(-1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.setX(1);
        }

        player.setVelocity(velocity); // Update the player's velocity
    }
}
