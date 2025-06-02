package com.arcana.game.card.components;

import com.arcana.game.core.ecs.Component;

/**
 * Component that handles the visibility state of a card (face up or face down).
 * When a card is face up, it's visible to all players.
 * When face down, it's only visible to its owner (handled by game rules).
 */
public class CardVisibilityComponent implements Component {
    private boolean isFaceUp;

    public CardVisibilityComponent(boolean initiallyFaceUp) {
        this.isFaceUp = initiallyFaceUp;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.isFaceUp = faceUp;
    }

    public void flip() {
        this.isFaceUp = !this.isFaceUp;
    }
} 