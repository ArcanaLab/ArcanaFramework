package ArcanaFramework.domain.table;

import ArcanaFramework.core.base.BaseComponent;
import ArcanaFramework.domain.card.CardEntity;
import ArcanaFramework.domain.player.PlayerEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Componente que almacena el estado de la mesa de juego.
 * Contiene información sobre el turno actual, la fase del juego y las zonas del tablero.
 */
public class TableComponent implements BaseComponent {
    private final TableEntity tableEntity;
    private PlayerEntity activePlayer;
    private int turnNumber = 1;
    private String gamePhase;
    private final Map<String, List<CardEntity>> zones = new HashMap<>();

    public TableComponent(TableEntity tableEntity) {
        this.tableEntity = tableEntity;
    }

    @Override
    public TableEntity getEntity() {
        return this.tableEntity;
    }

    public PlayerEntity getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(PlayerEntity activePlayer) {
        this.activePlayer = activePlayer;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public String getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(String gamePhase) {
        this.gamePhase = gamePhase;
    }

    public Map<String, List<CardEntity>> getZones() {
        return zones;
    }
    
    public List<CardEntity> getZone(String zoneName) {
        return zones.get(zoneName);
    }
}
