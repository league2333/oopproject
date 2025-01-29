// Lwjgl3Launcher.java
package com.mygdxgame.game.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Lwjgl3Launcher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Abstract Engine");
        config.setWindowedMode(800, 600);
        config.setResizable(false);
        new Lwjgl3Application(new GameEngine(), config);
    }
}