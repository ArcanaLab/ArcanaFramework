package ArcanaFramework.domain.table;

import ArcanaFramework.core.base.AbstractEntity;

/**
 * Entidad que representa la mesa de juego.
 * Esta entidad contiene todos los componentes que definen el estado de la mesa.
 */
public class TableEntity extends AbstractEntity {

    /**
     * Crea una nueva instancia de TableEntity y le añade un TableComponent.
     */
    public TableEntity() {
        add(new TableComponent(this));
    }
}
