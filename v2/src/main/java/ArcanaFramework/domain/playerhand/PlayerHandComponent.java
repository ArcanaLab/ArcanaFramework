package ArcanaFramework.domain.playerhand;

import ArcanaFramework.core.base.BaseComponent;

public class PlayerHandComponent implements BaseComponent {
    private PlayerHandEntity playerHandEntity;

    public PlayerHandComponent(PlayerHandEntity playerHandEntity) {
        this.playerHandEntity = playerHandEntity;
    }

    @Override
    public PlayerHandEntity getEntity() {
        return this.playerHandEntity;
    }
}
