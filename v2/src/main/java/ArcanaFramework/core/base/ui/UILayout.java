package ArcanaFramework.core.base.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;

import ArcanaFramework.core.base.ui.element.UIElement;

/**
 * Clase base abstracta para layouts de UI.
 * Permite organizar y posicionar elementos hijos de manera flexible.
 */
public abstract class UILayout extends UIElement {
    protected final List<UIElement> children;

    /**
     * Constructor de UILayout.
     * @param position Posición del layout.
     * @param size Tamaño del layout.
     * @param rotation Rotación del layout.
     * @param isVisible Visibilidad inicial.
     */
    public UILayout(Vector2 position, Vector2 size, float rotation, boolean isVisible) {
        super(position, size, rotation, isVisible);
        this.children = new ArrayList<>();
    }

    /**
     * Constructor de UILayout con visibilidad por defecto en true.
     * @param position Posición del layout.
     * @param size Tamaño del layout.
     * @param rotation Rotación del layout.
     */
    public UILayout(Vector2 position, Vector2 size, float rotation) {
        this(position, size, rotation, true);
    }

    /**
     * Agrega un elemento hijo al layout.
     * @param child Elemento UI a agregar.
     */
    public void addChild(UIElement child) {
        children.add(child);
        layoutChildren();
    }

    /**
     * Remueve un elemento hijo del layout.
     * @param child Elemento UI a remover.
     */
    public void removeChild(UIElement child) {
        children.remove(child);
        layoutChildren();
    }

    /**
     * Devuelve la lista de hijos del layout.
     * @return Lista de UIElement hijos.
     */
    public List<UIElement> getChildren() {
        return children;
    }

    /**
     * Organiza y posiciona los hijos según la lógica del layout.
     * Debe ser implementado por subclases.
     */
    public abstract void layoutChildren();

    @Override
    public void render(SpriteBatch batch) {
        for (UIElement child : children) {
            child.render(batch);
        }
    }
}
