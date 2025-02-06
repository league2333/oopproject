package SceneManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

import EntityManagement.Enemy;
import EntityManagement.Obstacle;
import EntityManagement.Player;
import EntityManagement.Vector;

public class GameScene extends Scene {
    private Player player;
    private ShapeRenderer shapeRenderer;
    private List<Obstacle> walls;
    private List<Enemy> enemies;

    public GameScene(Player player) {
        this.player = player;
        this.shapeRenderer = new ShapeRenderer();
        walls = new ArrayList<>();
        enemies = new ArrayList<>();
        createWalls();
        createEnemies();
    }

    private void createWalls() {
        int brickWidth = 40;
        int brickHeight = 20;
        float mortarGap = 2;
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        // Top border
        for (int x = 0; x < screenWidth; x += brickWidth) {
            walls.add(new Obstacle(new Vector(x, screenHeight - brickHeight), brickWidth - (int) mortarGap, brickHeight - (int) mortarGap));
        }
        // Bottom border
        for (int x = 0; x < screenWidth; x += brickWidth) {
            walls.add(new Obstacle(new Vector(x, 0), brickWidth - (int) mortarGap, brickHeight - (int) mortarGap));
        }
        // Left border
        for (int y = 0; y < screenHeight; y += brickHeight) {
            walls.add(new Obstacle(new Vector(0, y), brickWidth - (int) mortarGap, brickHeight - (int) mortarGap));
        }
        // Right border
        for (int y = 0; y < screenHeight; y += brickHeight) {
            walls.add(new Obstacle(new Vector(screenWidth - brickWidth, y), brickWidth - (int) mortarGap, brickHeight - (int) mortarGap));
        }
    }

    private void createEnemies() {
        // Create 4 enemies at random positions.
        for (int i = 0; i < 4; i++) {
            float x = MathUtils.random(50, Gdx.graphics.getWidth() - 50);
            float y = MathUtils.random(50, Gdx.graphics.getHeight() - 50);
            // Create enemy with dimensions 30x30 (adjust as needed).
            enemies.add(new Enemy(new Vector(x, y), 30, 30));
        }
    }

    // Simple AABB collision check between the player and an enemy.
    private boolean checkCollision(Player player, Enemy enemy) {
        // Player's position and size (using hardcoded values from Player class: width = 10, height = 20)
        float playerX = player.getPosition().x;
        float playerY = player.getPosition().y;
        float playerW = 10;
        float playerH = 20;

        float enemyX = enemy.getPosition().getX();
        float enemyY = enemy.getPosition().getY();
        float enemyW = enemy.getWidth();
        float enemyH = enemy.getHeight();

        return playerX < enemyX + enemyW && playerX + playerW > enemyX &&
                playerY < enemyY + enemyH && playerY + playerH > enemyY;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void render(SpriteBatch batch) {
        // Render walls.
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Obstacle wall : walls) {
            wall.render(shapeRenderer);
        }
        shapeRenderer.end();

        // Render enemies.
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Enemy enemy : enemies) {
            enemy.render(shapeRenderer);
        }
        shapeRenderer.end();

        // Render the player.
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        player.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void load() {
        // No resources to load for now.
    }

    @Override
    public void unload() {
        shapeRenderer.dispose();
    }

    @Override
    public void update() {
        // Update the player.
        player.update(Gdx.graphics.getDeltaTime());
        // Update each enemy and check for collision.
        for (Enemy enemy : enemies) {
            enemy.update();
            if (checkCollision(player, enemy)) {
                System.out.println("Game Over!");
                SceneManager.getInstance().switchScene("MainMenu");
            }
        }

        // Check for the P key to pause the game
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            SceneManager.getInstance().switchScene("Pause");
        }
    }

    @Override
    public void dispose() {
        unload();
    }
}
