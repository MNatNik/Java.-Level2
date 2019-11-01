package circles;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Sprite {
    private float vx = (float)(150.0D + Math.random() * 200.0D);
    private float vy = (float)(150.0D + Math.random() * 200.0D);
    private final Color color = new Color((int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D), (int)(Math.random() * 255.0D));

    Ball() {
        halfHeight = 20.0F + (float)(Math.random() * 50.0D);
        halfWidth = halfHeight;
    }

    void update(GameCanvas canvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
        if (getLeft() < (float)canvas.getLeft()) {
            setLeft((float)canvas.getLeft());
            vx = -vx;
        }

        if (getRight() > (float)canvas.getRight()) {
            setRight((float)canvas.getRight());
            vx = -vx;
        }

        if (getTop() < (float)canvas.getTop()) {
            setTop((float)canvas.getTop());
            vy = -vy;
        }

        if (getBottom() > (float)canvas.getBottom()) {
            setBottom((float)canvas.getBottom());
            vy = -vy;
        }

    }

    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(), (int)getTop(), (int)getWidth(), (int)getHeight());
    }
}
