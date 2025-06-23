package ArcanaFramework.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ArcanaFramework.helpers.ObserverHelper;

class UIElement extends Actor{
    private final ObserverHelper<Object> renderTrigger;
    private List<UIElement> children;
    private float posX, posY;
    
    public UIElement() {
        // Inicializamos el observer que ejecutará el render
        this.renderTrigger = new ObserverHelper<>();
        this.children = new ArrayList<>();
        
        // El observer ejecuta render cuando cualquier propiedad observada cambia
        this.renderTrigger.addObserver(value -> {
            this.render();
        });
    }
    
    // Método para actualizar la posición
    public void setPosition(float x, float y) {
        this.posX = x;
        this.posY = y;
        // Notificamos al observer para que ejecute el render
        renderTrigger.setValue(null);  // El valor no importa, solo queremos triggear el render
    }
    
    // Cualquier otra propiedad que quieras que cause un render
    public void setSize(float width, float height) {
        // ... actualizar tamaño ...
        renderTrigger.setValue(null);  // Trigger render
    }

    public void render() {
        this.render(0, 0);
    }

    public void render(float x, float y) {
        for (UIElement child : children) {
            child.render(this.posX + x, this.posY + y);
        }

        Gdx.graphics.requestRendering();
    }

}