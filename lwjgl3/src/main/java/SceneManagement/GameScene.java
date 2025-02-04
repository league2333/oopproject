package SceneManagement;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import EntityManagement.Player;

public class GameScene extends Scene {
    private Player player;
    private int width = 50;
    private int height = 50;
    private Texture playerTexture;

    // Modify the constructor to accept a Player object
    public GameScene(Player player) {
        this.player = player;
        // Load player texture (replace with the correct path to your texture)
        this.playerTexture = new Texture("player.png");
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();

        // Render player using the position from the Player object
        batch.draw(playerTexture, player.getPosition().getX(), player.getPosition().getY(), width, height);

        batch.end();
    }

    @Override
    public void load() {
        // Load any resources if needed (e.g., loading textures, sounds)
    }

    @Override
    public void unload() {
        // Clean up any resources (e.g., dispose textures)
        playerTexture.dispose();
    }

    @Override
    public void update() {
        player.update(); // Update player position
    }

    @Override
    public void dispose() {
        unload();
    }
}
