package com.arcana.game.card.components;

import com.arcana.game.core.ecs.Component;

/**
 * Component that tracks the current location and owner of a card.
 * This is used to determine where the card is in the game (deck, hand, play area, etc.)
 * and who owns or controls it.
 */
public class CardZoneComponent implements Component {
    private String currentZone;
    private String ownerId;

    public CardZoneComponent(String initialZone, String ownerId) {
        this.currentZone = initialZone;
        this.ownerId = ownerId;
    }

    public String getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(String newZone) {
        this.currentZone = newZone;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String newOwnerId) {
        this.ownerId = newOwnerId;
    }
} 