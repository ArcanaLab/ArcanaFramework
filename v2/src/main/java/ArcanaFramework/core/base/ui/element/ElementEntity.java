package ArcanaFramework.core.base.ui.element;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;


public abstract class ElementEntity extends Actor {
    //Transform variables
    protected Vector2 position;
    protected Vector2 size;

    //Visibility - Controls if we hide the element
    protected boolean visible;

    public ElementEntity(Vector2 position, Vector2 size)
    {
        this(position,size,true);
    }
    public ElementEntity(Vector2 position, Vector2 size, boolean visible)
    {
        this.position  = position;
        this.size      = size;
        this.visible   = visible;
    }
    //SETTERS
    public void setPosition(float x, float y)
    {
        position.set(x, y);
    }
    public void setSize(float width, float height)
    {
        this.size.set(width, height);
    }
    public void setVisibility(boolean visible)
    {
        this.visible = visible;
    }

    //GETTERS
    public Vector2 getPosition()
    {
        return position;
    }
    public Vector2 getSize()
    {
        return size;
    }

}
