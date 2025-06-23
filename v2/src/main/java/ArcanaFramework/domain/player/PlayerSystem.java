package ArcanaFramework.domain.player;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.domain.card.CardEntity;

/**
 * Sistema para gestionar la lógica de las entidades de jugador.
 * Proporciona métodos para manipular el estado del jugador y ejecuta la lógica de la IA.
 */
public abstract class PlayerSystem implements BaseSystem {

    /**
     * Añade una carta a la mano del jugador.
     * @param player La entidad del jugador.
     * @param card La entidad de la carta a añadir.
     */
    public void addCardToHand(PlayerEntity player, CardEntity card) {
        player.get(PlayerComponent.class).hand.add(card);
    }

    /**
     * Elimina una carta de la mano del jugador.
     * @param player La entidad del jugador.
     * @param card La entidad de la carta a eliminar.
     */
    public void removeCardFromHand(PlayerEntity player, CardEntity card) {
        player.get(PlayerComponent.class).hand.remove(card);
    }

    /**
     * Añade o actualiza un recurso para el jugador.
     * @param player La entidad del jugador.
     * @param type El tipo de recurso (ej. "mana", "health").
     * @param current El valor actual del recurso.
     * @param max El valor máximo del recurso.
     */
    public void addResource(PlayerEntity player, String type, int current, int max) {
        player.get(PlayerComponent.class).resources.put(type, new PlayerComponent.Resource(current, max));
    }

    /**
     * Obtiene un recurso específico del jugador.
     * @param player La entidad del jugador.
     * @param type El tipo de recurso.
     * @return El recurso, o null si no existe.
     */
    public PlayerComponent.Resource getResource(PlayerEntity player, String type) {
        return player.get(PlayerComponent.class).resources.get(type);
    }

    /**
     * Contiene la lógica para un jugador.
     */
    protected abstract void run(PlayerEntity player);
}