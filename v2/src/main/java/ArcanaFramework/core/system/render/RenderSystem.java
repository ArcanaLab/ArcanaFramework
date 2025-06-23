package ArcanaFramework.core.system.render;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.core.base.ui.UIElement;

public class RenderSystem extends BaseSystem {
    private SpriteBatch batch;

    public RenderSystem(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void update(double dt) {
        batch.begin();
        for (UIElement e : elements) {
            e.render(batch);
        }
        batch.end();
    }
}
