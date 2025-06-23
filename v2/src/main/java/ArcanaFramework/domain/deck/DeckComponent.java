package ArcanaFramework.domain.deck;

import ArcanaFramework.core.base.BaseComponent;
import ArcanaFramework.domain.card.CardEntity;

import java.util.ArrayList;
import java.util.List;

public class DeckComponent implements BaseComponent {
    public List<CardEntity> cards = new ArrayList<>();
    public int currentIndex = 0;
    private final DeckEntity deckEntity;

    public DeckComponent(DeckEntity deckEntity) {
        this.deckEntity = deckEntity;
    }

    @Override
    public DeckEntity getEntity() {
        return deckEntity;
    }
}
