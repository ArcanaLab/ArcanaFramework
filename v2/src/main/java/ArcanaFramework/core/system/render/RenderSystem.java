package ArcanaFramework.core.system.render;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.core.base.ui.element.UIElement;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.List;
import java.util.ArrayList;

public class RenderSystem implements BaseSystem {
    private SpriteBatch batch;
    private List<UIElement> elements;
    
    public RenderSystem(SpriteBatch batch) {
        this.batch = batch;
        this.elements = new ArrayList<>();
    }

    @Override
    public void update(float dt) {
        batch.begin();
        for (UIElement e : elements) {
            e.render(batch);
        }
        batch.end();
    }
}
