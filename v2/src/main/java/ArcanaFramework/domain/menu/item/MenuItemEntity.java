package ArcanaFramework.domain.menu.item;

import ArcanaFramework.core.base.AbstractEntity;

public class MenuItemEntity extends AbstractEntity {
    public MenuItemEntity(String label, String actionId) {
        MenuItemComponent mic = new MenuItemComponent(this);
        mic.label = label;
        mic.actionId = actionId;
        add(mic);
    }
}
