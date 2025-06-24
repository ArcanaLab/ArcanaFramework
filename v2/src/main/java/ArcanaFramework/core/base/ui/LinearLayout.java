package ArcanaFramework.core.base.ui;

import ArcanaFramework.core.base.ui.element.UIElement;
import ArcanaFramework.core.base.util.BatchManager;

import com.badlogic.gdx.math.Vector2;
import ArcanaFramework.core.base.enums.Orientation;

/**
 * Layout lineal que organiza los hijos en orientación vertical u horizontal.
 */
public class LinearLayout extends UILayout {
    private final float spacing;
    private final Orientation orientation;

    /**
     * Constructor de LinearLayout.
     * @param position Posición del layout.
     * @param size Tamaño del layout.
     * @param rotation Rotación del layout.
     * @param isVisible Visibilidad inicial.
     * @param orientation Orientación (HORIZONTAL o VERTICAL).
     * @param spacing Espaciado entre elementos.
     */
    public LinearLayout(BatchManager batch, Vector2 position, Vector2 size, boolean isVisible, Orientation orientation, float spacing) {
        super(batch, position, size, isVisible);
        this.orientation = orientation;
        this.spacing = spacing;
    }

    /**
     * Constructor con visibilidad por defecto en true.
     */
    public LinearLayout(BatchManager batch, Vector2 position, Vector2 size, Orientation orientation, float spacing) {
        this(batch, position, size, true, orientation, spacing);
    }

    /**
     * Organiza los hijos en fila o columna según la orientación.
     */
    @Override
    public void layoutChildren() {
        float offset = 0f;
        for (UIElement child : children) {
            if (orientation == Orientation.HORIZONTAL) {
                child.setPosition(this.getPosition().x + offset, this.getPosition().y);
                offset += child.getSize().x + spacing;
            } else {
                child.setPosition(this.getPosition().x, this.getPosition().y + offset);
                offset += child.getSize().y + spacing;
            }
        }
    }

    /**
     * Devuelve el espaciado entre elementos.
     */
    public float getSpacing() {
        return spacing;
    }

    /**
     * Devuelve la orientación del layout.
     */
    public Orientation getOrientation() {
        return orientation;
    }
} 