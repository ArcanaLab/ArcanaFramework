package ArcanaFramework.domain.playerhand;

import ArcanaFramework.core.base.BaseComponent;
import ArcanaFramework.domain.card.CardEntity;

import java.util.ArrayList;
import java.util.List;

public class PlayerHandComponent implements BaseComponent {
    public List<CardEntity> cards = new ArrayList<>();
    private final PlayerHandEntity playerHandEntity;

    public PlayerHandComponent(PlayerHandEntity playerHandEntity) {
        this.playerHandEntity = playerHandEntity;
    }

    @Override
    public PlayerHandEntity getEntity() {
        return playerHandEntity;
    }
}
