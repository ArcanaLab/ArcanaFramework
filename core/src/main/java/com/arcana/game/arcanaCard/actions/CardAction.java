package com.arcana.game.card.actions;

import com.arcana.game.core.ecs.Component;

/**
 * Base interface for all card actions following the Command pattern.
 * Each action represents something a card can do during the game.
 */
public interface CardAction {
    /**
     * Unique identifier for this type of action
     */
    String getActionId();
    
    /**
     * Validates if the action can be executed in the current game state
     */
    boolean canExecute(Object gameState);
    
    /**
     * Executes the action, modifying the game state
     */
    void execute(Object gameState);
} 