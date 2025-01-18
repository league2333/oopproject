package com.mygdxgame.game.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import SceneManagement.SceneManager;
import SceneManagement.GameScene;

public class GameEngine implements ApplicationListener {

    private ShapeRenderer shapeRenderer;
    private SceneManager sceneManager;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();  // Initialize ShapeRenderer here, after OpenGL context is set.
        sceneManager = SceneManager.getInstance();

        try {
            sceneManager.addScene("Game", new GameScene()); // Add GameScene
            sceneManager.switchScene("Game"); // Switch to GameScene
            Gdx.gl.glClearColor(0, 0, 0, 1);  // Set the clear color to black
        } catch (Exception e) {
            System.out.println("Error initializing GameScene: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        if (sceneManager.getActiveScene() != null) {
            // Clear the screen using Gdx.gl
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            sceneManager.getActiveScene().render(shapeRenderer); // Render the active scene
            shapeRenderer.end();
        }
    }

    @Override
    public void resize(int width, int height) {
        // Handle resizing logic if needed
    }

    @Override
    public void pause() {
        // Handle pausing logic if needed
    }

    @Override
    public void resume() {
        // Handle resume logic if needed
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();  // Dispose ShapeRenderer here
        sceneManager.dispose(); // Dispose of the scene manager when done
    }
}
