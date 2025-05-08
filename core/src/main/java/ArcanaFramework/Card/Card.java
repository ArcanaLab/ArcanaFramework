package ArcanaFramework.Card;


import ArcanaFramework.Pivot;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ArcanaFramework.UI.*;

public class Card<V> extends UIElement
{
    private final Texture borderTexture;
    private V value;
    private Pivot[] pivotsInCard;
    private Texture art;
    private boolean toggleOpacity = false;

    public Card(Vector2 position, Vector2 size, Texture art, Texture borderTexture,V value) {
        super(position, size, 0.0f);
        this.borderTexture = borderTexture;
        this.value = value;
        this.art = art;
    }
    public Card(Vector2 position, Vector2 size, Texture art, Texture borderTexture, V value,boolean isVisible) {
        super(position, size, 0.0f,isVisible);
        this.borderTexture = borderTexture;
        this.value = value;
        this.art = art;
    }

    // Draw Card
    public void draw(SpriteBatch batch)
    {
        if (art != null) {
            batch.setColor(1f, 1.0f, 1.0f, getOpacity());
            batch.draw(art, position.x, position.y,size.x, size.y);
        }
        if (borderTexture != null) {
            batch.setColor(0.5f, 0.0f, 1.0f, getOpacity());
            batch.draw(borderTexture, position.x, position.y, size.x / 2, size.y / 2, size.x, size.y, 1, 1, rotation, 0, 0,
                borderTexture.getWidth(), borderTexture.getHeight(), false, false);
        }
    }
    public void update(float delta) {
        //Do something
    }

    public void onHover() {
        if (!toggleOpacity) {
            setOpacity(0.5f);
            toggleOpacity = true;
        }
        else
        {
            setOpacity(1.0f);
            toggleOpacity = false;
        }

    }
}
