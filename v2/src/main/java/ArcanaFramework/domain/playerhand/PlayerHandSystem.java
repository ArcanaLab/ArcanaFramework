package ArcanaFramework.domain.playerhand;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.domain.card.CardEntity;

import java.util.Collections;
import java.util.List;

public class PlayerHandSystem implements BaseSystem {

    /**
     * Añade una carta a la mano del jugador.
     * @param hand La entidad de la mano del jugador.
     * @param card La carta a añadir.
     */
    public void addCard(PlayerHandEntity hand, CardEntity card) {
        if (hand.has(PlayerHandComponent.class)) {
            hand.get(PlayerHandComponent.class).cards.add(card);
        }
    }

    /**
     * Elimina una carta de la mano del jugador.
     * @param hand La entidad de la mano del jugador.
     * @param card La carta a eliminar.
     * @return true si la carta fue eliminada, false en caso contrario.
     */
    public boolean removeCard(PlayerHandEntity hand, CardEntity card) {
        if (hand.has(PlayerHandComponent.class)) {
            return hand.get(PlayerHandComponent.class).cards.remove(card);
        }
        return false;
    }

    /**
     * Obtiene la lista de cartas en la mano del jugador.
     * @param hand La entidad de la mano del jugador.
     * @return La lista de cartas.
     */
    public List<CardEntity> getCards(PlayerHandEntity hand) {
        if (hand.has(PlayerHandComponent.class)) {
            return hand.get(PlayerHandComponent.class).cards;
        }
        return Collections.emptyList();
    }

    /**
     * Obtiene el número de cartas en la mano.
     * @param hand La entidad de la mano del jugador.
     * @return El número de cartas.
     */
    public int getCardCount(PlayerHandEntity hand) {
        if (hand.has(PlayerHandComponent.class)) {
            return hand.get(PlayerHandComponent.class).cards.size();
        }
        return 0;
    }

    /**
     * Limpia la mano del jugador, eliminando todas las cartas.
     * @param hand La entidad de la mano del jugador.
     */
    public void clear(PlayerHandEntity hand) {
        if (hand.has(PlayerHandComponent.class)) {
            hand.get(PlayerHandComponent.class).cards.clear();
        }
    }

    @Override
    public void update(float delta) {
        // Este sistema es reactivo y no necesita actualizaciones por fotograma.
    }
}
