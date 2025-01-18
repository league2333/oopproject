package SceneManagement;

//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private static SceneManager instance;
    private Map<String, Scene> scenes;
    private Scene activeScene;

    private SceneManager() {
        scenes = new HashMap<>();
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    public void switchScene(String name) {
        activeScene = scenes.get(name);
        activeScene.load();
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    public void dispose() {
        for (Scene scene : scenes.values()) {
            scene.unload();
        }
    }
}
