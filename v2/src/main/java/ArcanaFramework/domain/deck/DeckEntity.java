package ArcanaFramework.domain.deck;

import ArcanaFramework.core.base.AbstractEntity;
import java.util.List;
import ArcanaFramework.domain.card.CardEntity;

public class DeckEntity extends AbstractEntity {

    public DeckEntity() {
        add(new DeckComponent(this));
    }

    public DeckEntity(List<CardEntity> cards){
        DeckComponent deckComponent = new DeckComponent(this);
        deckComponent.cards.addAll(cards);
        add(deckComponent);
    }
}
