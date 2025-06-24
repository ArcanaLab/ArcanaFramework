package ArcanaFramework.core.base.ui;

import ArcanaFramework.core.base.util.InputManager;
import ArcanaFramework.core.base.util.Position;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.InputProcessor;

/**
 * Clase base abstracta para todos los elementos de interfaz de usuario en el framework Arcana.
 * 
 * <p>Esta clase proporciona la funcionalidad base para renderizar elementos de UI
 * utilizando LibGDX. Todas las clases de UI deben extender esta clase e implementar
 * el método {@link #render(SpriteBatch)} para definir su comportamiento de renderizado.</p>
 * 
 * <p>La clase sigue el patrón de diseño Template Method, donde la estructura
 * de renderizado está definida pero la implementación específica se delega
 * a las subclases.</p>
 * 
 * @author ArcanaFramework
 * @version 2.0
 * @since 1.0
 */
public class UIElement {
    public Position position;

    public UIElement(Position position){
        this.position = position;
        _initializeEvents();
    }
    
    private void _render(SpriteBatch batch){
        throw new NotImplementedException("Not implemented");
    }
    
    
    /**
     * Renderiza el elemento de UI utilizando el SpriteBatch proporcionado.
     * 
     * <p>Este método debe ser implementado por todas las subclases para definir
     * cómo se debe renderizar el elemento específico. El SpriteBatch se proporciona
     * para mantener la eficiencia en el renderizado y permitir el batching de
     * operaciones de dibujo.</p>
     * 
     * <p>Es responsabilidad de la implementación:</p>
     * <ul>
     *   <li>Configurar el estado del SpriteBatch si es necesario</li>
     *   <li>Dibujar todos los elementos visuales del componente</li>
     *   <li>Restaurar el estado del SpriteBatch si fue modificado</li>
     * </ul>
     * 
     * @param batch El SpriteBatch utilizado para renderizar el elemento.
     *              No debe ser null.
     * @throws IllegalArgumentException Si batch es null
     */
    public void render(SpriteBatch batch){
        if(batch == null) throw new IllegalArgumentException("Batch cannot be null");
        _render(batch);
    }

    /**
     * Inicializa los eventos del elemento de UI.
     * 
     * <p>Este método debe ser implementado por todas las subclases para definir
     * cómo se debe renderizar el elemento específico. El SpriteBatch se proporciona
     * para mantener la eficiencia en el renderizado y permitir el batching de
     * operaciones de dibujo.</p>
     * 
     * 
     */
    private void _initializeEvents(){
        InputManager.getInstance().addProcessor(new InputProcessor() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                onClick();
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                onHover();
                return true;
            }
        });
    }

    public void onClick(){
        System.out.println("onClick");
    }

    public void onHover(){
        System.out.println("onHover");
    }
}
