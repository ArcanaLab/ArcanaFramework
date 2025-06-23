package ArcanaFramework.domain.card;

import ArcanaFramework.core.base.BaseComponent;

public class CardComponent implements BaseComponent {
    public String symbol;
    public String image;
    public String type;

    private final CardEntity cardEntity;

    public CardComponent(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    @Override
    public CardEntity getEntity() {
        return this.cardEntity;
    }
}