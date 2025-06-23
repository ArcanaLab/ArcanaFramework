package ArcanaFramework.domain.card;

import ArcanaFramework.core.base.AbstractEntity;

public class CardEntity extends AbstractEntity {
    public CardEntity(String symbol, String image, String type) {
        CardComponent cc = new CardComponent(this);
        cc.symbol = symbol;
        cc.image = image;
        cc.type = type;
        add(cc);
    }
}