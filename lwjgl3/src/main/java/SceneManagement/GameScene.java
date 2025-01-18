package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import EntityManagement.Player;
import EntityManagement.Vector;

public class GameScene extends Scene {
    private Player player;
    private int width = 50;
    private int height = 50;

    // Modify the constructor to accept a Player object
    public GameScene(Player player) {
        this.player = player;  // Set the player
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        
        // Render player using the position from the Player object
        shapeRenderer.rect(
            player.getPosition().getX(),
            player.getPosition().getY(),
            width,
            height
        );
        
        shapeRenderer.end();
    }

    @Override
    public void load() {
        // Load any resources if needed
    }

    @Override
    public void unload() {
        // Clean up any resources
    }

    @Override
    public void update() {
        player.update(); // Update player position
    }
}
