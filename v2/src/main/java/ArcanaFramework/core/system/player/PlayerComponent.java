package ArcanaFramework.core.system.player;

import ArcanaFramework.core.base.BaseComponent;

public class PlayerComponent implements BaseComponent {
    private final PlayerEntity playerEntity;

    public PlayerComponent(String displayName, boolean isHuman) {
        if (isHuman) {
            this.playerEntity = PlayerEntity.createHumanPlayer(displayName);
        } else {
            this.playerEntity = PlayerEntity.createAIPlayer(displayName);
        }
    }

    public PlayerEntity getPlayerEntity() {
        return this.playerEntity;
    }
}
