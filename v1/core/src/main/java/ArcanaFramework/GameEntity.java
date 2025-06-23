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
    protected Texture art;

    public GameEntity(Vector2 position, Vector2 size, float rotation, Texture texture)
    {
        this.position  = position;
        this.size      = size;
        this.rotation  = rotation;
        this.visible   = true;
        this.art = texture;
    }
    public GameEntity(Vector2 position, Vector2 size, float rotation, Texture texture, boolean visible)
    {
        this.position  = position;
        this.size      = size;
        this.rotation  = rotation;
        this.visible   = visible;
        this.art = texture;
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
    public void setVisibility(boolean visible)
    {
        this.visible = visible;
    }
    public void setArt(Texture art)
    {
        this.art = art;
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
    //Functions
    public void draw(SpriteBatch batch) {
        if (art != null) {
            batch.draw(art, position.x, position.y, size.x / 2, size.y / 2, size.x, size.y, 1, 1, rotation, 0, 0,
                art.getWidth(), art.getHeight(), false, false);
        }
    }

    public boolean isHovering(float mouseX, float mouseY)
    {
        return mouseX >= position.x && mouseX <= position.x + size.x && mouseY >= position.y && mouseY <= position.y + size.y;
    }

    //Update Function is called each frame
    //@delta: time passed between frames
    public abstract void update(float delta);

}
