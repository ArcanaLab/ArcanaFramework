package ArcanaFramework.domain.card;

import ArcanaFramework.core.base.BaseComponent;

public class CardComponent implements BaseComponent {
    private CardEntity cardEntity;

    public CardComponent(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    @Override
    public CardEntity getEntity() {
        return this.cardEntity;
    }
}