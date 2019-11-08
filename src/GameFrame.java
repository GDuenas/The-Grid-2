import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(int width, int height, String title){

        Dimension screensize = getToolkit().getScreenSize();

        this.setSize(screensize);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(title);

    }

}
