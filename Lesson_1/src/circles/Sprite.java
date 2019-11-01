package circles;

import java.awt.Graphics;

public class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    public Sprite() {
    }

    protected float getLeft() {
        return x - halfWidth;
    }

    protected void setLeft(float left) {
        x = left + halfWidth;
    }

    protected float getRight() {
        return x + halfWidth;
    }

    protected void setRight(float right) {
        x = right - halfWidth;
    }

    protected float getTop() {
        return y - halfHeight;
    }

    protected void setTop(float top) {
        y = top + halfHeight;
    }

    protected float getBottom() {
        return y + halfHeight;
    }

    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    protected float getWidth() {
        return 2.0F * halfWidth;
    }

    protected float getHeight() {
        return 2.0F * halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {
    }

    void render(GameCanvas canvas, Graphics g) {
    }
}
