package ArcanaFramework.domain.player;

import ArcanaFramework.core.base.BaseComponent;
import ArcanaFramework.domain.card.CardEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Almacena todos los datos relacionados con un jugador.
 */
public class PlayerComponent implements BaseComponent {

    /**
     * Representa un recurso del jugador, como maná o vida.
     */
    public static class Resource {
        public int current;
        public int max;

        public Resource(int current, int max) {
            this.current = current;
            this.max = max;
        }
    }

    private final PlayerEntity entity;

    public final String id;
    public String displayName;
    public final boolean isHuman;
    public final List<CardEntity> hand = new ArrayList<>();
    public final Map<String, Resource> resources = new HashMap<>();

    public PlayerComponent(PlayerEntity entity, String displayName, boolean isHuman) {
        this.entity = entity;
        this.id = UUID.randomUUID().toString();
        this.displayName = displayName;
        this.isHuman = isHuman;
    }

    public PlayerEntity getEntity() {
        return entity;
    }
}
