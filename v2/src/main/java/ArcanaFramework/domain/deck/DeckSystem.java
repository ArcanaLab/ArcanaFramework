package ArcanaFramework.domain.deck;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.domain.card.CardEntity;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckSystem implements BaseSystem {
    private final Random random = new Random();

    /**
     * Baraja las cartas en la entidad del mazo.
     * @param deck La entidad del mazo a barajar.
     */
    public void shuffle(DeckEntity deck) {
        if (deck.has(DeckComponent.class)) {
            DeckComponent dc = deck.get(DeckComponent.class);
            Collections.shuffle(dc.cards, random);
            dc.currentIndex = 0;
        }
    }

    /**
     * Saca una carta de la entidad del mazo.
     * @param deck La entidad del mazo de la que sacar la carta.
     * @return La entidad de la carta sacada, o null si no quedan cartas.
     */
    public CardEntity draw(DeckEntity deck) {
        if (deck.has(DeckComponent.class)) {
            DeckComponent dc = deck.get(DeckComponent.class);
            if (dc.currentIndex < dc.cards.size()) {
                return dc.cards.get(dc.currentIndex++);
            }
        }
        return null;
    }

    /**
     * Reinicia el mazo, poniendo el índice de la carta actual a 0.
     * No baraja el mazo.
     * @param deck La entidad del mazo a reiniciar.
     */
    public void reset(DeckEntity deck) {
        if (deck.has(DeckComponent.class)) {
            deck.get(DeckComponent.class).currentIndex = 0;
        }
    }

    /**
     * Añade una sola carta al mazo.
     * @param deck La entidad del mazo.
     * @param card La entidad de la carta a añadir.
     */
    public void addCard(DeckEntity deck, CardEntity card) {
        if (deck.has(DeckComponent.class)) {
            deck.get(DeckComponent.class).cards.add(card);
        }
    }

    /**
     * Añade una lista de cartas al mazo.
     * @param deck La entidad del mazo.
     * @param cards La lista de entidades de cartas a añadir.
     */
    public void addCards(DeckEntity deck, List<CardEntity> cards) {
        if (deck.has(DeckComponent.class)) {
            deck.get(DeckComponent.class).cards.addAll(cards);
        }
    }

    @Override
    public void update(float delta) {
        // Este sistema es reactivo y no necesita actualizaciones por fotograma.
        // Sus métodos son llamados por otros sistemas cuando se necesita interactuar con un mazo.
    }
}
