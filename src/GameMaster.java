import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;

public class GameMaster implements Screen {
    private ArrayList<Entity> entities;

    public GameMaster() {
        entities = new ArrayList<>();
        entities.add(new Circle(100, 100, 30));
        entities.add(new TextureObject(200, 200, 50, 50));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Entity entity : entities) {
            entity.update(delta);
            entity.render();
        }
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}

// Entity.java (Base class for game objects)
public abstract class Entity {
    protected float x, y;
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public abstract void update(float delta);
    public abstract void render();
}

// iMoveable.java (Interface for movable objects)
public interface iMoveable {
    void move(float dx, float dy);
}