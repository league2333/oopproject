package SceneManagement;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Scene {
    public abstract void render(ShapeRenderer shapeRenderer);
    public abstract void load();
    public abstract void unload();
    public abstract void update();
}
