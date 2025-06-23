package ArcanaFramework.Card;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ArcanaFramework.GameEntity;
import ArcanaFramework.Pivot;

public class Card<V> extends GameEntity
{
    private final Texture borderTexture;
    private V value;
    private Pivot[] pivotsInCard;

    public Card(Vector2 position, Vector2 size, Texture art, Texture borderTexture,V value) {
        super(position, size, 0.0f, art);
        this.borderTexture = borderTexture;
        this.value = value;
    }
    public Card(Vector2 position, Vector2 size, Texture art, Texture borderTexture, V value,boolean isVisible) {
        super(position, size, 0.0f, art,isVisible);
        this.borderTexture = borderTexture;
        this.value = value;
    }

    // Draw Card
    public void draw(SpriteBatch batch) {
        super.draw(batch); //ART
        if (borderTexture != null) {
            batch.draw(borderTexture, position.x, position.y, size.x / 2, size.y / 2, size.x, size.y, 1, 1, rotation, 0, 0,
                borderTexture.getWidth(), borderTexture.getHeight(), false, false);
        }
    }
    
    @Override
    public void update(float delta) {
        //Do something
    }
}
