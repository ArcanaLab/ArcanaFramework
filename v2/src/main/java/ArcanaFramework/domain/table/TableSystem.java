package ArcanaFramework.domain.table;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.domain.card.CardEntity;
import ArcanaFramework.domain.player.PlayerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sistema que gestiona la lógica de la mesa de juego, como turnos, fases y zonas.
 */
public class TableSystem implements BaseSystem {

    private TableComponent getComponent(TableEntity table) {
        return table.get(TableComponent.class);
    }

    /**
     * Pasa al siguiente turno, actualizando el jugador activo e incrementando el número de turno.
     * @param table La entidad de la mesa.
     * @param nextPlayer El siguiente jugador activo.
     */
    public void nextTurn(TableEntity table, PlayerEntity nextPlayer) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            tc.setActivePlayer(nextPlayer);
            tc.setTurnNumber(tc.getTurnNumber() + 1);
        }
    }

    /**
     * Obtiene el jugador activo actual.
     * @param table La entidad de la mesa.
     * @return El jugador activo.
     */
    public PlayerEntity getActivePlayer(TableEntity table) {
        TableComponent tc = getComponent(table);
        return (tc != null) ? tc.getActivePlayer() : null;
    }

    /**
     * Obtiene el número de turno actual.
     * @param table La entidad de la mesa.
     * @return El número de turno.
     */
    public int getTurnNumber(TableEntity table) {
        TableComponent tc = getComponent(table);
        return (tc != null) ? tc.getTurnNumber() : -1;
    }

    /**
     * Establece la fase de juego actual.
     * @param table La entidad de la mesa.
     * @param phase La nueva fase del juego.
     */
    public void setGamePhase(TableEntity table, String phase) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            tc.setGamePhase(phase);
        }
    }

    /**
     * Obtiene la fase de juego actual.
     * @param table La entidad de la mesa.
     * @return La fase de juego actual.
     */
    public String getGamePhase(TableEntity table) {
        TableComponent tc = getComponent(table);
        return (tc != null) ? tc.getGamePhase() : null;
    }

    /**
     * Crea una nueva zona en la mesa si no existe.
     * @param table La entidad de la mesa.
     * @param zoneName El nombre de la zona a crear.
     */
    public void createZone(TableEntity table, String zoneName) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            tc.getZones().putIfAbsent(zoneName, new ArrayList<>());
        }
    }

    /**
     * Añade una carta a una zona específica.
     * @param table La entidad de la mesa.
     * @param zoneName El nombre de la zona.
     * @param card La carta a añadir.
     */
    public void addCardToZone(TableEntity table, String zoneName, CardEntity card) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            createZone(table, zoneName); // Asegura que la zona exista
            tc.getZone(zoneName).add(card);
        }
    }

    /**
     * Mueve una carta de una zona a otra.
     * @param table La entidad de la mesa.
     * @param card La carta a mover.
     * @param fromZoneName El nombre de la zona de origen.
     * @param toZoneName El nombre de la zona de destino.
     */
    public void moveCardToZone(TableEntity table, CardEntity card, String fromZoneName, String toZoneName) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            List<CardEntity> fromZone = tc.getZone(fromZoneName);
            if (fromZone != null && fromZone.remove(card)) {
                addCardToZone(table, toZoneName, card);
            }
        }
    }
    
    /**
     * Obtiene todas las cartas de una zona específica.
     * @param table La entidad de la mesa.
     * @param zoneName El nombre de la zona.
     * @return Una lista de las cartas en la zona, o una lista vacía si la zona no existe.
     */
    public List<CardEntity> getCardsInZone(TableEntity table, String zoneName) {
        TableComponent tc = getComponent(table);
        if (tc != null) {
            return tc.getZones().getOrDefault(zoneName, Collections.emptyList());
        }
        return Collections.emptyList();
    }

    @Override
    public void update(float delta) {
        // Este sistema es reactivo y sus métodos son llamados por otros sistemas.
    }
}
