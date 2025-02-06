package SceneManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

public class PauseScene extends Scene {
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private SpriteBatch batch;
    
    // Button dimensions and positions
    private final int BUTTON_WIDTH = 400;
    private final int BUTTON_HEIGHT = 100;
    private final int BUTTON_X = 200;
    
    private final int RESUME_Y = 400;
    private final int MENU_Y = 250;
    private final int QUIT_Y = 100;

    public PauseScene() {
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        batch = new SpriteBatch();
    }

    @Override
    public void render(SpriteBatch gameBatch) {
        // Draw buttons
        Gdx.gl.glEnable(Gdx.gl.GL_BLEND);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        
        shapeRenderer.rect(BUTTON_X, RESUME_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        shapeRenderer.rect(BUTTON_X, MENU_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        shapeRenderer.rect(BUTTON_X, QUIT_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        
        shapeRenderer.end();
        Gdx.gl.glDisable(Gdx.gl.GL_BLEND);

        // Draw text
        batch.begin();
        font.draw(batch, "Resume", BUTTON_X + 170, RESUME_Y + 60);
        font.draw(batch, "Menu", BUTTON_X + 180, MENU_Y + 60);
        font.draw(batch, "Quit", BUTTON_X + 180, QUIT_Y + 60);
        batch.end();
    }

    @Override
    public void update() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY(); // Convert to OpenGL coordinates

            if (isButtonClicked(mouseX, mouseY, RESUME_Y)) {
                SceneManager.getInstance().switchScene("Game");
            }
            else if (isButtonClicked(mouseX, mouseY, MENU_Y)) {
                SceneManager.getInstance().switchScene("MainMenu");
            }
            else if (isButtonClicked(mouseX, mouseY, QUIT_Y)) {
                Gdx.app.exit();
            }
        }
    }

    private boolean isButtonClicked(float mouseX, float mouseY, int buttonY) {
        return mouseX >= BUTTON_X && 
               mouseX <= BUTTON_X + BUTTON_WIDTH && 
               mouseY >= buttonY && 
               mouseY <= buttonY + BUTTON_HEIGHT;
    }

    @Override
    public void load() {
        // Load resources if needed
    }

    @Override
    public void unload() {
        // Unload resources if needed
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        font.dispose();
        batch.dispose();
    }
}