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
    private float buttonX, buttonY, buttonWidth, buttonHeight;

    @Override
    public void load() {
        background = new Texture("background.png");  // Replace with your background image
        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt")); // Load custom font
        shapeRenderer = new ShapeRenderer();

        // Button position & size (adjust as needed)
        buttonWidth = 200;
        buttonHeight = 80;
        buttonX = (Gdx.graphics.getWidth() - buttonWidth) / 2; // Center horizontally
        buttonY = 150; // Fixed Y position
    }

    @Override
    public void unload() {
        background.dispose();
        font.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public void render(SpriteBatch batch) {
        // Draw background
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        // Draw the main logo "JP Survival"
        font.getData().setScale(1);
        font.setColor(Color.NAVY); 
        String logoText = "JP Survival";
        float logoWidth = font.getSpaceXadvance() * logoText.length() * 2;
        float logoX = (Gdx.graphics.getWidth() - logoWidth) / 2;
        float logoY = Gdx.graphics.getHeight() - 100;

        // Draw shadow for the logo
        font.setColor(Color.BLACK);
        font.draw(batch, logoText, logoX + 2, logoY - 2);
        font.setColor(Color.WHITE);
        font.draw(batch, logoText, logoX, logoY);

        // Draw the "Start Game" button as a rounded rectangle
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0.2f, 0.6f, 1, 1)); 
        drawRoundedRect(shapeRenderer, buttonX, buttonY, buttonWidth, buttonHeight, 20);
        shapeRenderer.end();
        batch.begin(); // Restart SpriteBatch for text rendering

        // Draw the "Start Game" text inside the button
        font.getData().setScale(0.4f); 
        font.setColor(Color.WHITE);
        String buttonText = "Start Game";
        float textWidth = font.getSpaceXadvance() * buttonText.length() * 0.4f;
        float textX = buttonX + (buttonWidth - (textWidth+120) ) / 2;
        float textY = buttonY + (buttonHeight / 2) + 10; 

        // Draw shadow for the button text
        font.setColor(Color.BLACK);
        font.draw(batch, buttonText, textX + 1, textY - 1);
        font.setColor(Color.WHITE);
        font.draw(batch, buttonText, textX, textY);
    }

    @Override
    public void update() {
        // Detect mouse click on "Start Game" button
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            float mouseX = Gdx.input.getX();
            float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
            
            // Check if the mouse click is within the bounds of the "Start Game" button
            if (mouseX >= buttonX && mouseX <= buttonX + buttonWidth &&
                mouseY >= buttonY && mouseY <= buttonY + buttonHeight) {
                SceneManager.getInstance().switchScene("Game");
            }
        }
    }

    @Override
    public void dispose() {
        unload();
    }

    // Helper method to draw a rounded rectangle
    private void drawRoundedRect(ShapeRenderer shapeRenderer, float x, float y, float width, float height, float radius) {
        // Center rectangle
        shapeRenderer.rect(x + radius, y + radius, width - 2 * radius, height - 2 * radius);

        // Four side rectangles
        shapeRenderer.rect(x + radius, y, width - 2 * radius, radius);
        shapeRenderer.rect(x + radius, y + height - radius, width - 2 * radius, radius);
        shapeRenderer.rect(x, y + radius, radius, height - 2 * radius);
        shapeRenderer.rect(x + width - radius, y + radius, radius, height - 2 * radius);

        // Four quarter circles for the corners
        shapeRenderer.arc(x + radius, y + radius, radius, 180f, 90f);
        shapeRenderer.arc(x + width - radius, y + radius, radius, 270f, 90f);
        shapeRenderer.arc(x + width - radius, y + height - radius, radius, 0f, 90f);
        shapeRenderer.arc(x + radius, y + height - radius, radius, 90f, 90f);
    }
}