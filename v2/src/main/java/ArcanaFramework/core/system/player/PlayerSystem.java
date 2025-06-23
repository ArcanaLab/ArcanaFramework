package ArcanaFramework.core.system.player;

import ArcanaFramework.core.base.BaseSystem;

public abstract class PlayerSystem extends BaseSystem {
    private PlayerComponent playerComponent;

    public PlayerSystem(PlayerComponent playerComponent) {
        this.playerComponent = playerComponent;
    }

    @Override
    public void update(float delta) {
    
    }

    protected abstract void handleHumanInput(PlayerEntity player);
    protected abstract void runAI(PlayerEntity player);
}