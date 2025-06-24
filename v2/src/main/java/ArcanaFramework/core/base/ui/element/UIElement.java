package ArcanaFramework.core.base.ui.element;

import java.util.ArrayList;
import java.util.List;

import ArcanaFramework.core.base.util.BatchManager;
import ArcanaFramework.core.base.util.InputManager;
import ArcanaFramework.core.base.util.Observer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;


public class UIElement extends ElementEntity {
    private final BatchManager batchManager;
    protected final SpriteBatch batch;

    private final Observer<Object> renderTrigger;
    private InputAdapter input;
    private float opacity = 1.0f;
    private boolean isHovered = false;

    public UIElement(BatchManager batch, Vector2 position,Vector2 size)
    {
        this(batch, position,size,true);
    }

    public UIElement(BatchManager batch, Vector2 position,Vector2 size, boolean isVisible)
    {
        super(position, size, isVisible);
        // Inicializamos el observer que ejecutará el render
        this.renderTrigger = new Observer<>();
        this.batchManager = batch;
        this.batch = batchManager.getBatch();

        // El observer ejecuta render cuando cualquier propiedad observada cambia
        this.renderTrigger.addObserver(value -> {
            this.render();
            Gdx.graphics.requestRendering();
        });
        initializeInput();
    }

    private void initializeInput() {
        input = new InputAdapter() {
            
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                // Convertir las coordenadas de pantalla a coordenadas del mundo
                Vector2 touchPos = new Vector2(screenX, screenY);

                // Verificar si el toque está dentro de los límites de la carta
                if (containsPoint(touchPos.x, touchPos.y)) {
                    onClick();
                    return true;
                }
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                Vector2 mousePos = new Vector2(screenX, screenY);

                boolean wasHovered = isHovered;
                isHovered = containsPoint(mousePos.x, mousePos.y);

                if (wasHovered != isHovered) {
                    onHover();
                }
                return isHovered;
            }
        };

        InputManager.getInstance().addProcessor(input);
    }

    private boolean containsPoint(float x, float y) {
        return x >= position.x && x <= position.x + size.x &&
            y >= position.y && y <= position.y + size.y;
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        renderTrigger.setValue(null);
    }

    public void setSize(float width, float height) {
        super.setSize(width, height);
        renderTrigger.setValue(null);
    }

    public void render() {}
    public void onClick(){}
    public void onHover(){}


    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }
}
