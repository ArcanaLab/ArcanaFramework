package ArcanaFramework.domain.card;

import ArcanaFramework.core.base.AbstractEntity;

public class CardEntity extends AbstractEntity {
    public CardEntity(){
        add(new CardComponent(this));
    }
}