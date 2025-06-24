package ArcanaFramework.core.base.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ArcanaFramework.core.base.exceptions.NotImplementedException;

/**
 * Elemento de UI para mostrar texto en pantalla.
 * Permite personalizar el texto, fuente, color y alineación.
 * 
 * @author ArcanaFramework
 * @version 2.0
 * @since 1.0
 */
public class UIText extends UIElement {
    private String text;
    private BitmapFont font;
    private Color color;

    /**
     * Constructor principal: todos los parámetros.
     */
    public UIText(Vector2 position, Vector2 size, String text, BitmapFont font, Color color) {
        super(position, size, true);
        this.text = text;
        this.font = font;
        this.color = color;
    }


    /**
     * Constructor con color por defecto (blanco).
     */
    public UIText(Vector2 position, Vector2 size, String text, BitmapFont font) {
        this(position, size, text, font, Color.WHITE);
    }

    /**
     * Constructor con fuente y color por defecto.
     */
    public UIText(Vector2 position, Vector2 size, String text) {
        this(position, size, text, new BitmapFont(), Color.WHITE);
    }

    /**
     * Dibuja el texto usando SpriteBatch y BitmapFont.
     * @param batch SpriteBatch de LibGDX
     */
    public void draw(SpriteBatch batch) {
        if (!visible) return;
        font.setColor(color);
        font.draw(batch, text, position.x, position.y + size.y);
    }

    /**
     * Dibuja el texto (sobrescribe el método base, pero requiere SpriteBatch externo).
     * Lanza excepción si se llama sin SpriteBatch.
     */
    @Override
    public void draw() {
        throw new NotImplementedException("UIText requiere SpriteBatch externo para dibujar. Usa draw(SpriteBatch batch)");
    }

    // Getters y setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Libera los recursos de la fuente si es necesario.
     */
    public void dispose() {
        if (font != null) font.dispose();
    }

    @Override
    public void onClick() {
        // Por defecto, no hace nada. Puede ser sobrescrito.
    }

    @Override
    public void onHover() {
        // Por defecto, no hace nada. Puede ser sobrescrito.
    }
}
