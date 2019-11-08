import java.awt.*;

public class Test {

    public static void main(String[] args) {
        GameFrame test = new GameFrame(1920, 1080, "The Grid 2 - ALPHA 0.1");
        Color player1 = new Color(224, 120, 0);
        Color player2 = new Color(0, 75, 185);

        test.add(new GamePanel(test.getWidth(), test.getHeight(), player1, player2));
        test.setVisible(true);

    }

}
