import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;

public class Circle extends Entity implements iMoveable {
    private float radius;
    private ShapeRenderer shapeRenderer;
    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
        shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void update(float delta) {}
    @Override
    public void render() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }
    @Override
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }
}