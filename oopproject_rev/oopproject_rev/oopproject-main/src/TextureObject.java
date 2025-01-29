import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class TextureObject extends Entity {
    private float width, height;
    private ShapeRenderer shapeRenderer;
    public TextureObject(float x, float y, float width, float height) {
        super(x, y);
        this.width = width;
        this.height = height;
        shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void update(float delta) {}
    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }
}