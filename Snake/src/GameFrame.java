import org.ietf.jgss.GSSManager;

import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame() {

        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();  // takes the jframe and fill it around the components we add to the frame
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
