package ArcanaFramework.core.base.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.InputMultiplexer;

/**
 * Gestor centralizado de input para el framework Arcana.
 * Implementa el patrón Singleton para asegurar una única instancia del multiplexer.
 */
public class InputManager {
    private static InputManager instance;
    private InputMultiplexer multiplexer;

    private InputManager() {
        multiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);
    }

    /**
     * Obtiene la instancia única del InputManager.
     * @return La instancia del InputManager
     */
    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    /**
     * Agrega un nuevo processor al multiplexer.
     * @param processor El InputProcessor a agregar
     */
    public void addProcessor(InputProcessor processor) {
        if (processor != null) {
            multiplexer.addProcessor(processor);
        }
    }

    /**
     * Agrega un processor al inicio de la lista (mayor prioridad).
     * @param processor El InputProcessor a agregar con prioridad
     */
    public void addProcessorFirst(InputProcessor processor) {
        if (processor != null) {
            multiplexer.addProcessor(0, processor);
        }
    }

    /**
     * Remueve un processor del multiplexer.
     * @param processor El InputProcessor a remover
     */
    public void removeProcessor(InputProcessor processor) {
        if (processor != null) {
            multiplexer.removeProcessor(processor);
        }
    }

    /**
     * Limpia todos los processors.
     */
    public void clearProcessors() {
        multiplexer.clear();
    }

    /**
     * Obtiene el multiplexer actual.
     * @return El InputMultiplexer actual
     */
    public InputMultiplexer getMultiplexer() {
        return multiplexer;
    }
}