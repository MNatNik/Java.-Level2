package circles;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    private final MainCircles gameController;
    private long lastFrameTime;

    public GameCanvas(MainCircles gameController) {
        this.gameController = gameController;
        lastFrameTime = System.nanoTime();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (float)(currentTime - lastFrameTime) * 1.0E-9F;
        lastFrameTime = currentTime;
        gameController.onDrawFrame(this, g, deltaTime);

        try {
            Thread.sleep(17L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return this.getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return this.getHeight() - 1;
    }
}
