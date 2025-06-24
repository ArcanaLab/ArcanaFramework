package ArcanaFramework.UI;

import java.util.ArrayList;
import java.util.List;

import ArcanaFramework.GameEntity;
import ArcanaFramework.Utils.InputManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ArcanaFramework.Utils.Observer;

public class UIElement extends GameEntity {
    private final Observer<Object> renderTrigger;
    private List<UIElement> children;
    private InputAdapter input;
    private float opacity = 1.0f;
    private boolean isHovered = false;

    public UIElement(Vector2 position,Vector2 size)
    {
        this(position,size,rotation,true);
    }

    public UIElement(Vector2 position,Vector2 size, boolean isVisible)
    {
        super(position, size, isVisible);
        // Inicializamos el observer que ejecutará el render
        this.renderTrigger = new Observer<>();
        this.children = new ArrayList<>();

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

    //SETTERS
    // Metodo para actualizar la posición
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        // Notificamos al observer para que ejecute el render
        renderTrigger.setValue(null);  // El valor no importa, solo queremos triggear el render
    }

    // Cualquier otra propiedad que quieras que cause un render
    public void setSize(float width, float height) {
        super.setSize(width, height);
        renderTrigger.setValue(null);  // Trigger render
    }

    //RENDERER
    public void render() {
        this.render(this.getPosition().x, this.getPosition().y);
    }

    public void render(float x, float y) {
        this.draw();
        for (UIElement child : children) {
            child.render(this.getPosition().x + x, this.getPosition().y + y);
        }
    }

    public void draw()
    {
        throw new NotImplementedException();
    }
    public void onClick()
    {
        throw new NotImplementedException();
    }

    public void onHover()
    {
        throw new NotImplementedException();
    }


    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }
}
