package circles;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Background extends JPanel {

    void updateColor(final Component component) {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int red = component.getBackground().getRed();
                int green = component.getBackground().getGreen();
                int blue = component.getBackground().getBlue();
                if (red >= 3 && green >= 2 && blue >= 1) {
                    component.setBackground(new Color(red - 3, green - 2, blue - 1));
                } else {
                    component.setBackground(new Color(255, 255, 255));
                }

            }
        };
        Timer timer = new Timer(4000, action);
        timer.start();
    }
}

