package com.mygdxgame.game.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import SceneManagement.SceneManager;
import SceneManagement.GameScene;
import InputOutputManagement.InputManager;
import EntityManagement.Vector;
import EntityManagement.Player;

public class GameEngine implements ApplicationListener {
    private ShapeRenderer shapeRenderer;
    private SceneManager sceneManager;
    private InputManager inputManager;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();  // Initialize ShapeRenderer here, after OpenGL context is set.
        sceneManager = SceneManager.getInstance();
        inputManager = new InputManager();

        // Initialize the player and add the GameScene to the scene manager
        Vector startPosition = new Vector(50, 50);  // Initialize the Vector position
        Player player = new Player(startPosition);  // Create the player object

        sceneManager.addScene("Game", new GameScene(player));  // Pass player to the scene
        sceneManager.switchScene("Game");  // Set GameScene as the active scene

        try {
            Gdx.gl.glClearColor(0, 0, 0, 1); // Set clear color to black
        } catch (Exception e) {
            System.out.println("Error initializing GameScene: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        // Handle input - get player from active scene
        GameScene activeScene = (GameScene) sceneManager.getActiveScene();
        if (activeScene != null) {
            inputManager.processInput(activeScene.getPlayer());
        }

        // Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update and render the scene
        sceneManager.getActiveScene().update();
        sceneManager.getActiveScene().render(shapeRenderer);
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
        shapeRenderer.dispose();
        sceneManager.dispose();
    }
}
