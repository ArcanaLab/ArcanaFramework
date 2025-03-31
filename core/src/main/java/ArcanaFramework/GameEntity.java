package ArcanaFramework;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;


public abstract class GameEntity extends Actor {
    //Transform variables
    protected Vector2 position;
    protected Vector2 size;
    protected float rotation;

    //Visibility - Controls if we hide the element
    protected boolean visible;

    public GameEntity(Vector2 position, Vector2 size, float rotation)
    {
        this(position,size,rotation,true);
    }
    public GameEntity(Vector2 position, Vector2 size, float rotation, boolean visible)
    {
        this.position  = position;
        this.size      = size;
        this.rotation  = rotation;
        this.visible   = visible;
    }
    //SETTERS
    public void setPosition(float x, float y)
    {
        position.set(x, y);
    }
    public void setRotation(float rotation)
    {
        this.rotation = rotation;
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
    public float getRotation()
    {
        return rotation;
    }


}
