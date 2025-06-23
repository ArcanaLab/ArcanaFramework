package ArcanaFramework.core.system.player;

import ArcanaFramework.core.base.BaseEntity;
import ArcanaFramework.domain.card.CardEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerEntity implements BaseEntity {

    /**
     * Represents a player's resource, like mana or health.
     */
    public static class Resource {
        private int current;
        private int max;

        public Resource(int current, int max) {
            this.current = current;
            this.max = max;
        }

        public int getCurrent() { return current; }
        public void setCurrent(int current) { this.current = Math.min(current, max); }
        public int getMax() { return max; }
        public void setMax(int max) { this.max = max; }
    }

    private final String id;
    private String displayName;
    private final boolean isHuman;
    private final List<CardEntity> hand;
    private final Map<String, Resource> resources;

    private PlayerEntity(String id, String displayName, boolean isHuman) {
        this.id = id;
        this.displayName = displayName;
        this.isHuman = isHuman;
        this.hand = new ArrayList<>();
        this.resources = new HashMap<>();
    }

    /**
     * Creates a new human-controlled player entity.
     * @param displayName The name to display for the player.
     * @return A new instance of a human PlayerEntity.
     */
    public static PlayerEntity createHumanPlayer(String displayName) {
        return new PlayerEntity(UUID.randomUUID().toString(), displayName, true);
    }

    /**
     * Creates a new AI-controlled player entity.
     * @param displayName The name to display for the player.
     * @return A new instance of an AI PlayerEntity.
     */
    public static PlayerEntity createAIPlayer(String displayName) {
        return new PlayerEntity(UUID.randomUUID().toString(), displayName, false);
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public List<CardEntity> getHand() {
        return hand;
    }

    public void addCardToHand(CardEntity card) {
        this.hand.add(card);
    }

    public void removeCardFromHand(CardEntity card) {
        this.hand.remove(card);
    }

    public Map<String, Resource> getResources() {
        return resources;
    }

    public void addResource(String type, int current, int max){
        this.resources.put(type, new Resource(current, max));
    }
    
    public Resource getResource(String type){
        return this.resources.get(type);
    }
}
