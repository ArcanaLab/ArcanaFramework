package ArcanaFramework.core.base;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntity implements BaseEntity {
    private final Map<Class<? extends BaseComponent>, BaseComponent> components = new HashMap<>();

    public <T extends BaseComponent> T add(T component) {
        components.put(component.getClass(), component);
        return component;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseComponent> T get(Class<T> componentClass) {
        return (T) components.get(componentClass);
    }

    public <T extends BaseComponent> boolean has(Class<T> componentClass) {
        return components.containsKey(componentClass);
    }

    public <T extends BaseComponent> void remove(Class<T> componentClass) {
        components.remove(componentClass);
    }
} 