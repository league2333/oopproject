package SceneManagement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenuScene extends Scene {
    private Texture background;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;
    private float startButtonX, startButtonY, buttonWidth, buttonHeight;
    private float exitButtonX, exitButtonY;

    @Override
    public void load() {
        background = new Texture("background.png");
        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt"));
        shapeRenderer = new ShapeRenderer();

        buttonWidth = 200;
        buttonHeight = 80;
        startButtonX = (Gdx.graphics.getWidth() - buttonWidth) / 2;
        startButtonY = 150;
        
        exitButtonX = startButtonX;
        exitButtonY = 50;
    }

    @Override
    public void unload() {
        background.dispose();
        font.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        font.getData().setScale(2);
        String logoText = "L.A.S.T"; // Updated game name
        float logoWidth = font.getSpaceXadvance() * logoText.length() * 2;
        float logoX = (Gdx.graphics.getWidth() - logoWidth) / 2;
        float logoY = Gdx.graphics.getHeight() - 100;        
        font.draw(batch, logoText, logoX, logoY);

        // Draw subtitle "LONE . ARENA . SURVIVOR . TRIAL"
        font.getData().setScale(0.4f);
        String subText = "LONE . ARENA . SURVIVOR . TRIAL";
        float subX = (Gdx.graphics.getWidth() - (subText.length() * 14)) / 2;
        float subY = logoY - 100;
        font.draw(batch, subText, subX, subY);

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0.2f, 0.6f, 1, 1));
        drawRoundedRect(shapeRenderer, startButtonX, startButtonY, buttonWidth, buttonHeight, 20);
        
        shapeRenderer.setColor(new Color(0.8f, 0.2f, 0.2f, 1));
        drawRoundedRect(shapeRenderer, exitButtonX, exitButtonY, buttonWidth, buttonHeight, 20);
        shapeRenderer.end();

        batch.begin();
        font.getData().setScale(0.4f);
        
        drawButtonText(batch, "Start Game", startButtonX, startButtonY);
        drawButtonText(batch, "Exit", exitButtonX+34, exitButtonY);
    }

    @Override
    public void update() {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (mouseX >= startButtonX && mouseX <= startButtonX + buttonWidth &&
                mouseY >= startButtonY && mouseY <= startButtonY + buttonHeight) {
                SceneManager.getInstance().switchScene("Game");
            }
            
            if (mouseX >= exitButtonX && mouseX <= exitButtonX + buttonWidth &&
                mouseY >= exitButtonY && mouseY <= exitButtonY + buttonHeight) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void dispose() {
        unload();
    }

    private void drawRoundedRect(ShapeRenderer shapeRenderer, float x, float y, float width, float height, float radius) {
        shapeRenderer.rect(x + radius, y + radius, width - 2 * radius, height - 2 * radius);
        shapeRenderer.rect(x + radius, y, width - 2 * radius, radius);
        shapeRenderer.rect(x + radius, y + height - radius, width - 2 * radius, radius);
        shapeRenderer.rect(x, y + radius, radius, height - 2 * radius);
        shapeRenderer.rect(x + width - radius, y + radius, radius, height - 2 * radius);
        shapeRenderer.arc(x + radius, y + radius, radius, 180f, 90f);
        shapeRenderer.arc(x + width - radius, y + radius, radius, 270f, 90f);
        shapeRenderer.arc(x + width - radius, y + height - radius, radius, 0f, 90f);
        shapeRenderer.arc(x + radius, y + height - radius, radius, 90f, 90f);
    }

    private void drawButtonText(SpriteBatch batch, String text, float x, float y) {
        float textWidth = font.getSpaceXadvance() * text.length() * 0.4f;
        float textX = x + (buttonWidth - (textWidth + 120)) / 2;
        float textY = y + (buttonHeight / 2) + 10;
        
        font.setColor(Color.BLACK);
        font.draw(batch, text, textX + 1, textY - 1);
        font.setColor(Color.WHITE);
        font.draw(batch, text, textX, textY);
    }
}
