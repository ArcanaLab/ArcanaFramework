package ArcanaFramework.domain.deck;

import ArcanaFramework.core.base.BaseComponent;

public class DeckComponent implements BaseComponent {
    private DeckEntity deckEntity;

    public DeckComponent(DeckEntity deckEntity) {
        this.deckEntity = deckEntity;
    }

    @Override
    public DeckEntity getEntity() {
        return this.deckEntity;
    }
}
