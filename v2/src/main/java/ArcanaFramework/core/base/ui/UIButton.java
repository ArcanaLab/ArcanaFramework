package ArcanaFramework.core.base.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Implementación de un botón de UI para el framework Arcana.
 * 
 * <p>Esta clase extiende UIElement para proporcionar un botón funcional
 * con estados visuales (normal, hover, presionado) y manejo de eventos.</p>
 * 
 * @author ArcanaFramework
 * @version 2.0
 * @since 1.0
 */
public class UIButton extends UIElement {
    private String text;
    private Color backgroundColor;
    private Color hoverColor;
    private Color pressedColor;
    private Color textColor;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;
    
    /**
     * Constructor para crear un botón con texto.
     * 
     * @param position La posición del botón
     * @param width El ancho del botón
     * @param height La altura del botón
     * @param text El texto del botón
     */
    public UIButton(Position position, float width, float height, String text) {
        super(position, width, height);
        this.text = text;
        this.font = new BitmapFont();
        this.shapeRenderer = new ShapeRenderer();
        
        // Colores por defecto
        this.backgroundColor = new Color(0.2f, 0.2f, 0.2f, 1.0f);
        this.hoverColor = new Color(0.3f, 0.3f, 0.3f, 1.0f);
        this.pressedColor = new Color(0.1f, 0.1f, 0.1f, 1.0f);
        this.textColor = Color.WHITE;
    }
    
    /**
     * Constructor simplificado para crear un botón.
     * 
     * @param position La posición del botón
     * @param text El texto del botón
     */
    public UIButton(Position position, String text) {
        this(position, 150, 50, text);
    }
    
    @Override
    protected void _render(SpriteBatch batch) {
        // Pausar el SpriteBatch para usar ShapeRenderer
        batch.end();
        
        // Configurar ShapeRenderer
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        
        // Determinar el color basado en el estado
        Color currentColor = backgroundColor;
        if (isPressed) {
            currentColor = pressedColor;
        } else if (isHovered) {
            currentColor = hoverColor;
        }
        
        // Dibujar el fondo del botón
        shapeRenderer.setColor(currentColor);
        shapeRenderer.rect(position.x, position.y, width, height);
        
        shapeRenderer.end();
        
        // Reanudar SpriteBatch para el texto
        batch.begin();
        
        // Dibujar el texto
        font.setColor(textColor);
        font.draw(batch, text, 
                 position.x + width / 2 - font.getData().spaceWidth * text.length() / 2,
                 position.y + height / 2 + font.getData().capHeight / 2);
    }
    
    /**
     * Sobrescribe el método onClick para comportamiento personalizado.
     */
    @Override
    public void onClick() {
        System.out.println("Botón clickeado: " + text);
        // Aquí puedes agregar tu lógica personalizada
    }
    
    /**
     * Sobrescribe el método onHoverEnter para efectos visuales.
     */
    @Override
    public void onHoverEnter() {
        System.out.println("Mouse entró en botón: " + text);
    }
    
    /**
     * Sobrescribe el método onHoverExit para efectos visuales.
     */
    @Override
    public void onHoverExit() {
        System.out.println("Mouse salió del botón: " + text);
    }
    
    // Getters y setters para personalización
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    
    public Color getHoverColor() {
        return hoverColor;
    }
    
    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
    
    public Color getPressedColor() {
        return pressedColor;
    }
    
    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }
    
    public Color getTextColor() {
        return textColor;
    }
    
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
    
    /**
     * Libera los recursos utilizados por el botón.
     */
    public void dispose() {
        if (font != null) {
            font.dispose();
        }
        if (shapeRenderer != null) {
            shapeRenderer.dispose();
        }
    }
}
