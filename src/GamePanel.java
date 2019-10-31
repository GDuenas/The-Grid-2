import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private int width, height;
    private ArrayList<LightBike> bikeList = new ArrayList<>();

    public GamePanel(int width, int height){
        super();
        this.setVisible(true);
        this.width = width;
        this.height = height;
        bikeList.add(new LightBike(100, 50, Color.red));
        bikeList.add(new LightBike(150, 100, Color.blue));

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);

        System.out.println("paintcomponent");

        Color stripe = new Color(0, 165, 161);
        g.setColor(stripe);
        int divider = 15;
        for(int i = 0; i < divider; i++){
            g.drawLine(width/divider + (width/divider)*i, 0, width/divider + (width/divider)*i, height);
            g.drawLine(0, width/divider + (width/divider)*i, width, width/divider + (width/divider)*i);
        }

        for(int i = 0; i < bikeList.size(); i++){
            LightBike currentBike = bikeList.get(i);
            g.setColor(currentBike.getColor());
            System.out.println(currentBike.getPosX());
            g.fillRect(currentBike.getPosX(), currentBike.getPosY(), currentBike.width, currentBike.height);
        }

    }

}
