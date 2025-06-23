package ArcanaFramework.domain.menu;

import ArcanaFramework.core.base.BaseComponent;
import ArcanaFramework.domain.menu.item.MenuItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuComponent implements BaseComponent {
    public List<MenuItemEntity> items = new ArrayList<>();
    public int selectedIndex = -1;
    private final MenuEntity menuEntity;

    public MenuComponent(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
    }

    @Override
    public MenuEntity getEntity() {
        return this.menuEntity;
    }
}
