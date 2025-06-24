package ArcanaFramework.core.base.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Gestor singleton para el SpriteBatch compartido en la UI.
 * Permite acceder a una única instancia de SpriteBatch y gestiona su ciclo de vida.
 */
public final class BatchManager {
    private static BatchManager instance;
    private final SpriteBatch batch;

    private BatchManager() {}

    /**
     * Obtiene la instancia única del BatchManager.
     * @return Instancia de BatchManager
     */
    public static BatchManager getInstance() {
        if (instance == null) {
            instance = new BatchManager();
        }
        return instance;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    /**
     * Devuelve el SpriteBatch compartido.
     * @return SpriteBatch global
     */
    public SpriteBatch getBatch() {
        if (batch == null) {
            throw new IllegalStateException("BatchManager no ha sido inicializado");
        }
        return batch;
    }

    /**
     * Libera los recursos del SpriteBatch.
     * Debe llamarse al cerrar la aplicación.
     */
    public void dispose() {
        batch.dispose();
    }
}
