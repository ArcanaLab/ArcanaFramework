package ArcanaFramework.core.base.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class UIElement {
    public Position position;

    public UIElement(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract void render(SpriteBatch batch);
}
