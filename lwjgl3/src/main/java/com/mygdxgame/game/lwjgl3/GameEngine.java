package com.mygdxgame.game.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import SceneManagement.SceneManager;
import SceneManagement.GameScene;
import SceneManagement.MainMenuScene;
import SceneManagement.Scene;
import InputOutputManagement.InputManager;
import EntityManagement.Vector;
import EntityManagement.Player;

public class GameEngine implements ApplicationListener {
    private SpriteBatch spriteBatch; // Use SpriteBatch for rendering
    private SceneManager sceneManager;
    private InputManager inputManager;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();  // Initialize SpriteBatch here, after OpenGL context is set.
        sceneManager = SceneManager.getInstance();
        inputManager = new InputManager();

        // Initialize the player and add the GameScene to the scene manager
        Vector startPosition = new Vector(50, 50);
        Player player = new Player(startPosition);
        
        // sceneManager.addScene("Game", new GameScene(player));  // Pass player to the scene
        // sceneManager.switchScene("Game");  // Set GameScene as the active scene
        
        // Add MainMenuScene and switch to it
        sceneManager.addScene("MainMenu", new MainMenuScene());
        sceneManager.switchScene("MainMenu");

        try {
            Gdx.gl.glClearColor(0, 0, 0, 1); // Set clear color to black
        } catch (Exception e) {
            System.out.println("Error initializing GameScene: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        Scene activeScene = sceneManager.getActiveScene(); 
        if (activeScene instanceof GameScene) {
            GameScene gameScene = (GameScene) activeScene;
            inputManager.processInput(gameScene.getPlayer());
        }

        // Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update and render the scene
        activeScene.update();
        
        // Render using SpriteBatch (rendering logic depends on the scene type)
        spriteBatch.begin();
        activeScene.render(spriteBatch);
        spriteBatch.end();
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
        spriteBatch.dispose(); // Dispose of the SpriteBatch
        sceneManager.dispose();
    }
}
