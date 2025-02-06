package com.mygdxgame.game.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import SceneManagement.SceneManager;
import SceneManagement.GameScene;
import SceneManagement.MainMenuScene;
import SceneManagement.PauseScene;
import SceneManagement.Scene;
import InputOutputManagement.InputManager;
import EntityManagement.Player;

public class GameEngine implements ApplicationListener {
    private SpriteBatch spriteBatch;
    private SceneManager sceneManager;
    private InputManager inputManager;
    private boolean isPaused;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        sceneManager = SceneManager.getInstance();
        inputManager = new InputManager();

        // Initialize with window boundaries
        float minX = +50;
        float maxX = Gdx.graphics.getWidth() - 40;
        float minY = +35;
        float maxY = Gdx.graphics.getHeight() - 40;

        // Initialize the player
        Player player = new Player(
            new Vector2(400, 300),
            minX, maxX, minY, maxY
        );

        // Add scenes to the SceneManager
        sceneManager.addScene("MainMenu", new MainMenuScene());
        sceneManager.addScene("Game", new GameScene(player));
        sceneManager.addScene("Pause", new PauseScene());

        // Start with the MainMenu
        sceneManager.switchScene("MainMenu");

        Gdx.gl.glClearColor(0, 0, 0, 1);
        isPaused = false;
    }

    @Override
    public void render() {
        Scene activeScene = sceneManager.getActiveScene();

        // Handle input and update only if the game is not paused
        if (activeScene instanceof GameScene) {
            GameScene gameScene = (GameScene) activeScene;
            
            if (!isPaused) {
                inputManager.processInput(gameScene.getPlayer());

                // Check for pause
                if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
                    isPaused = true;
                    sceneManager.switchScene("Pause");
                    return;
                }
            }
        } else if (activeScene instanceof PauseScene) {
            // Check for unpause
            if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
                isPaused = false;
                sceneManager.switchScene("Game");
                return;
            }
        }

        // Clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update and render the scene
        activeScene.update();

        // Render using SpriteBatch
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
        spriteBatch.dispose();
        sceneManager.dispose();
    }
}