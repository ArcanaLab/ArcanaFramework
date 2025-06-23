package ArcanaFramework.domain.menu.item;

import ArcanaFramework.core.base.BaseComponent;

public class MenuItemComponent implements BaseComponent {
    private MenuItemEntity menuItemEntity;

    public MenuItemComponent(MenuItemEntity menuItemEntity) {
        this.menuItemEntity = menuItemEntity;
    }

    @Override
    public MenuItemEntity getEntity() {
        return this.menuItemEntity;
    }
}

