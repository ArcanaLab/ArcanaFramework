package ArcanaFramework.domain.menu;

import ArcanaFramework.core.base.AbstractEntity;
import ArcanaFramework.domain.menu.item.MenuItemEntity;

import java.util.List;

public class MenuEntity extends AbstractEntity {

    public MenuEntity() {
        add(new MenuComponent(this));
    }

    public MenuEntity(List<MenuItemEntity> items){
        MenuComponent menuComponent = new MenuComponent(this);
        menuComponent.items.addAll(items);
        add(menuComponent);
    }
}
