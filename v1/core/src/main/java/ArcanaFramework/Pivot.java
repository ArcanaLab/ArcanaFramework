package ArcanaFramework;

import com.badlogic.gdx.math.Vector2;

public enum Pivot {
    TOP_LEFT(0, 0), TOP_CENTER(0.5f, 0), TOP_RIGHT(1, 0),
    CENTER_LEFT(0, 0.5f), CENTER(0.5f, 0.5f), CENTER_RIGHT(1, 0.5f),
    BOTTOM_LEFT(0, 1), BOTTOM_CENTER(0.5f, 1), BOTTOM_RIGHT(1, 1);

    private final float pivotX;
    private final float pivotY;
    private final float offsetX = 0;
    private final float offsetY = 0;
    public static final int MAX_PIVOTS = 9;
    Pivot(float pivotX, float pivotY) {
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    /*
     * Returns the adjusted position based on the pivot point
     */
    public Vector2 applyPivot(Vector2 position, float width, float height,float offsetX,float offsetY)
    {
        float adjustedX = position.x - (width * pivotX)  + offsetX;
        float adjustedY = position.y - (height * pivotY) + offsetY;
        return new Vector2(adjustedX, adjustedY);
    }
}
