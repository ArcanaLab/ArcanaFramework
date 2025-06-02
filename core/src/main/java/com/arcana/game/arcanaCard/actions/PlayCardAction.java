package com.arcana.game.card.actions;

/**
 * Basic action for playing a card. This is the default action available to all cards.
 */
public class PlayCardAction implements CardAction {
    public static final String ACTION_ID = "play";
    private final int cardEntityId;

    public PlayCardAction(int cardEntityId) {
        this.cardEntityId = cardEntityId;
    }

    @Override
    public String getActionId() {
        return ACTION_ID;
    }

    @Override
    public boolean canExecute(Object gameState) {
        // La lógica específica de validación se implementará según el juego
        return true;
    }

    @Override
    public void execute(Object gameState) {
        // La lógica específica de ejecución se implementará según el juego
    }

    public int getCardEntityId() {
        return cardEntityId;
    }
} 