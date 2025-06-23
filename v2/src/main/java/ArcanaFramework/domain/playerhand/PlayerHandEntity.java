package ArcanaFramework.domain.playerhand;

import ArcanaFramework.core.base.AbstractEntity;
import ArcanaFramework.domain.card.CardEntity;

import java.util.List;

public class PlayerHandEntity extends AbstractEntity {

    public PlayerHandEntity() {
        add(new PlayerHandComponent(this));
    }

    public PlayerHandEntity(List<CardEntity> cards){
        PlayerHandComponent playerHandComponent = new PlayerHandComponent(this);
        playerHandComponent.cards.addAll(cards);
        add(playerHandComponent);
    }
}
