package ArcanaFramework.domain.player;

import ArcanaFramework.core.base.AbstractEntity;

/**
 * Representa a un jugador en el juego. Puede ser humano o controlado por la IA.
 * Esta clase es una entidad que contiene un {@link PlayerComponent} con sus datos.
 */
public class PlayerEntity extends AbstractEntity {

    /**
     * Crea una nueva entidad de jugador, asumiendo que es humano.
     * @param displayName El nombre a mostrar para el jugador.
     */
    public PlayerEntity(String displayName) {
        this(displayName, true);
    }

    /**
     * Crea una nueva entidad de jugador.
     * @param displayName El nombre a mostrar para el jugador.
     * @param isHuman Verdadero si es un jugador humano, falso si es una IA.
     */
    public PlayerEntity(String displayName, boolean isHuman) {
        add(new PlayerComponent(this, displayName, isHuman));
    }
}
