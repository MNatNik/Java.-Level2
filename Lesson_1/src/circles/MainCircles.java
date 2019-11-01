package circles;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainCircles extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[10];
    Background bg = new Background();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(3);
        setBounds(600, 200, 800, 600);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, "Center");
        initApplication();
        setVisible(true);
    }

    private void initApplication() {
        for(int i = 0; i < sprites.length; ++i) {
            sprites[i] = new Ball();
        }

    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
        updateColor(canvas);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for(int i = 0; i < sprites.length; ++i) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(GameCanvas canvas, Graphics g) {
        for(int i = 0; i < sprites.length; ++i) {
            sprites[i].render(canvas, g);
        }

    }

    void updateColor(GameCanvas canvas) {
        bg.updateColor(canvas);
    }
}
