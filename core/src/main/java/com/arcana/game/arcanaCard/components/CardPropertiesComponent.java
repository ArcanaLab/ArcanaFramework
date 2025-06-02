package com.arcana.game.card.components;

import com.arcana.game.core.ecs.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Component that holds all properties for a card.
 * Properties are stored as string key-value pairs to support any game-specific attributes.
 *
 * Standard properties that should be present in all cards:
 * - "name": The display name of the card
 * - "type": The type of the card (e.g., "creature", "spell", etc.)
 *
 * Additional properties can be added as needed for specific game mechanics.
 */
public class CardPropertiesComponent implements Component {
    public static final String NAME_PROPERTY = "name";
    public static final String TYPE_PROPERTY = "type";
    
    private final Map<String, String> properties;

    public CardPropertiesComponent(String name, String type) {
        this.properties = new HashMap<>();
        setName(name);
        setType(type);
    }

    public CardPropertiesComponent(Map<String, String> initialProperties) {
        this.properties = new HashMap<>(initialProperties);
        // Ensure required properties exist
        if (!properties.containsKey(NAME_PROPERTY) || !properties.containsKey(TYPE_PROPERTY)) {
            throw new IllegalArgumentException("Initial properties must include 'name' and 'type'");
        }
    }

    // Convenience methods for standard properties
    public String getName() {
        return getProperty(NAME_PROPERTY);
    }

    public void setName(String name) {
        setProperty(NAME_PROPERTY, name);
    }

    public String getType() {
        return getProperty(TYPE_PROPERTY);
    }

    public void setType(String type) {
        setProperty(TYPE_PROPERTY, type);
    }

    // Generic property methods
    public void setProperty(String key, String value) {
        properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public boolean hasProperty(String key) {
        return properties.containsKey(key);
    }

    public Map<String, String> getAllProperties() {
        return new HashMap<>(properties);
    }

    public void removeProperty(String key) {
        if (!key.equals(NAME_PROPERTY) && !key.equals(TYPE_PROPERTY)) {
            properties.remove(key);
        }
    }
} 