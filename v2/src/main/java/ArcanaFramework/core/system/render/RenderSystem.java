package ArcanaFramework.core.system.render;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.core.base.ui.element.UIElement;
import ArcanaFramework.core.base.util.BatchManager;
import java.util.List;
import java.util.ArrayList;

public class RenderSystem implements BaseSystem {
    private final BatchManager batchManager;
    private List<UIElement> elements;
    
    public RenderSystem(BatchManager batchManager) {
        this.batchManager = batchManager;
        this.elements = new ArrayList<>();
    }

    @Override
    public void update(float dt) {
        batchManager.getBatch().begin();
        for (UIElement e : elements) {
            e.render();
        }
        batchManager.getBatch().end();
    }
}
