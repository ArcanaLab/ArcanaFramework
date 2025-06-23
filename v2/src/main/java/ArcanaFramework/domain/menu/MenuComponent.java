package ArcanaFramework.domain.menu;

import ArcanaFramework.core.base.BaseComponent;

public class MenuComponent implements BaseComponent {
    private MenuEntity menuEntity;

    public MenuComponent(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
    }

    @Override
    public MenuEntity getEntity() {
        return this.menuEntity;
    }
}
