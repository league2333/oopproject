package SceneManagement;

//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene {
    //public abstract void render(ShapeRenderer shapeRenderer);
    public abstract void render(SpriteBatch batch); // Add this method to be overridden in subclasses
    public abstract void load();
    public abstract void unload();
    public abstract void update();
    public abstract void dispose(); 
}
