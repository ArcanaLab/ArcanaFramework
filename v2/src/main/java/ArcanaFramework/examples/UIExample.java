package ArcanaFramework.examples;

import ArcanaFramework.core.base.ui.UIButton;
import ArcanaFramework.core.base.util.Position;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Ejemplo de uso del sistema de UI del framework Arcana.
 * 
 * <p>Este ejemplo demuestra cómo crear y usar elementos de UI
 * con manejo de eventos de input en LibGDX.</p>
 * 
 * @author ArcanaFramework
 * @version 2.0
 * @since 1.0
 */
public class UIExample extends ApplicationAdapter {
    private SpriteBatch batch;
    private CustomButton button1;
    private CustomButton button2;
    private CustomButton button3;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        
        // Crear botones con diferentes configuraciones
        button1 = new CustomButton(new Position(100, 300), "Botón 1", 1);
        button1.setBackgroundColor(new Color(0.2f, 0.6f, 0.2f, 1.0f));
        button1.setHoverColor(new Color(0.3f, 0.7f, 0.3f, 1.0f));
        button1.setPressedColor(new Color(0.1f, 0.5f, 0.1f, 1.0f));
        
        button2 = new CustomButton(new Position(300, 300), "Botón 2", 2);
        button2.setBackgroundColor(new Color(0.6f, 0.2f, 0.2f, 1.0f));
        button2.setHoverColor(new Color(0.7f, 0.3f, 0.3f, 1.0f));
        button2.setPressedColor(new Color(0.5f, 0.1f, 0.1f, 1.0f));
        
        button3 = new CustomButton(new Position(500, 300), "Botón 3", 3);
        button3.setBackgroundColor(new Color(0.2f, 0.2f, 0.6f, 1.0f));
        button3.setHoverColor(new Color(0.3f, 0.3f, 0.7f, 1.0f));
        button3.setPressedColor(new Color(0.1f, 0.1f, 0.5f, 1.0f));
    }
    
    @Override
    public void render() {
        // Limpiar la pantalla
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Iniciar el batch de renderizado
        batch.begin();
        
        // Renderizar todos los botones
        button1.render(batch);
        button2.render(batch);
        button3.render(batch);
        
        batch.end();
    }
    
    @Override
    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }
        if (button1 != null) {
            button1.dispose();
        }
        if (button2 != null) {
            button2.dispose();
        }
        if (button3 != null) {
            button3.dispose();
        }
    }
    
    /**
     * Clase personalizada de botón que extiende UIButton para demostrar
     * cómo personalizar el comportamiento de los eventos.
     */
    private static class CustomButton extends UIButton {
        private int buttonId;
        
        public CustomButton(Position position, String text, int buttonId) {
            super(position, text);
            this.buttonId = buttonId;
        }
        
        @Override
        public void onClick() {
            System.out.println("¡Botón " + buttonId + " fue clickeado!");
            
            switch (buttonId) {
                case 1:
                    setText("¡Click!");
                    break;
                case 2:
                    setBackgroundColor(Color.YELLOW);
                    break;
                case 3:
                    // Este botón cambiará el color de todos los botones
                    // pero necesitaríamos una referencia al ejemplo principal
                    System.out.println("Botón 3: Cambiaría colores de todos");
                    break;
            }
        }
        
        @Override
        public void onHoverEnter() {
            System.out.println("Mouse entró en botón " + buttonId);
        }
        
        @Override
        public void onHoverExit() {
            System.out.println("Mouse salió del botón " + buttonId);
        }
    }
} 