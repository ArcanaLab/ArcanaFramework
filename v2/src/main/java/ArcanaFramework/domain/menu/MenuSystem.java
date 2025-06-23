package ArcanaFramework.domain.menu;

import ArcanaFramework.core.base.BaseSystem;
import ArcanaFramework.domain.menu.item.MenuItemEntity;

import java.util.List;

public class MenuSystem extends BaseSystem {

    /**
     * Adds a single menu item to the menu.
     * @param menu The menu entity.
     * @param item The menu item entity to add.
     */
    public void addMenuItem(MenuEntity menu, MenuItemEntity item) {
        if (menu.has(MenuComponent.class)) {
            menu.get(MenuComponent.class).items.add(item);
        }
    }

    /**
     * Adds a list of menu items to the menu.
     * @param menu The menu entity.
     * @param items The list of menu item entities to add.
     */
    public void addMenuItems(MenuEntity menu, List<MenuItemEntity> items) {
        if (menu.has(MenuComponent.class)) {
            menu.get(MenuComponent.class).items.addAll(items);
        }
    }

    /**
     * Selects the next item in the menu. Wraps around if at the end.
     * @param menu The menu entity.
     */
    public void selectNext(MenuEntity menu) {
        if (menu.has(MenuComponent.class)) {
            MenuComponent mc = menu.get(MenuComponent.class);
            if (!mc.items.isEmpty()) {
                mc.selectedIndex = (mc.selectedIndex + 1) % mc.items.size();
            }
        }
    }

    /**
     * Selects the previous item in the menu. Wraps around if at the beginning.
     * @param menu The menu entity.
     */
    public void selectPrevious(MenuEntity menu) {
        if (menu.has(MenuComponent.class)) {
            MenuComponent mc = menu.get(MenuComponent.class);
            if (!mc.items.isEmpty()) {
                mc.selectedIndex = (mc.selectedIndex - 1 + mc.items.size()) % mc.items.size();
            }
        }
    }

    /**
     * Gets the currently selected menu item.
     * @param menu The menu entity.
     * @return The selected MenuItemEntity, or null if no item is selected or the menu is empty.
     */
    public MenuItemEntity getSelectedItem(MenuEntity menu) {
        if (menu.has(MenuComponent.class)) {
            MenuComponent mc = menu.get(MenuComponent.class);
            if (mc.selectedIndex >= 0 && mc.selectedIndex < mc.items.size()) {
                return mc.items.get(mc.selectedIndex);
            }
        }
        return null;
    }

    @Override
    public void update(float delta) {
        // This system is reactive and doesn't need per-frame updates.
        // Its methods are called by other systems when interaction with a menu is needed.
    }
}
