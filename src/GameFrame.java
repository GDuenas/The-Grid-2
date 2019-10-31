import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(int width, int height, String title){
        this.setSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle(title);

    }

}
