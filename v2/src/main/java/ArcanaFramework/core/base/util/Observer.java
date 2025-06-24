package ArcanaFramework.core.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Helper para implementar el patrón Observer de manera genérica.
 * Permite observar cambios en cualquier tipo de objeto y ejecutar callbacks cuando estos ocurren.
 */
public class Observer<T> {
    private T value;
    private final List<Consumer<T>> observers;

    /**
     * Constructor que inicializa el helper con un valor inicial
     * @param initialValue El valor inicial a observar
     */
    public Observer(T initialValue) {
        this.value = initialValue;
        this.observers = new ArrayList<>();
    }

    /**
     * Constructor que inicializa el helper sin valor inicial
     */
    public Observer() {
        this.observers = new ArrayList<>();
    }

    /**
     * Obtiene el valor actual
     * @return El valor actual
     */
    public T getValue() {
        return value;
    }

    /**
     * Establece un nuevo valor y notifica a todos los observadores
     * @param newValue El nuevo valor
     */
    public void setValue(T newValue) {
        this.value = newValue;
        notifyObservers();
    }

    /**
     * Agrega un nuevo observador que será notificado cuando el valor cambie
     * @param observer El callback a ejecutar cuando el valor cambie
     * @return Una función que permite remover el observador
     */
    public Runnable addObserver(Consumer<T> observer) {
        observers.add(observer);
        return () -> observers.remove(observer);
    }

    /**
     * Notifica a todos los observadores con el valor actual
     */
    public void notifyObservers() {
        for (Consumer<T> observer : observers) {
            observer.accept(value);
        }
    }

    /**
     * Remueve todos los observadores
     */
    public void clearObservers() {
        observers.clear();
    }
}
