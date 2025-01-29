import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractGameEngine extends ApplicationAdapter {
    protected SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        initialize();
    }
    
    protected abstract void initialize();
    public abstract void update(float delta);
    public abstract void renderGame();

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());
        renderGame();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

