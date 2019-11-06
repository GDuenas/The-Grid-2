import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, Runnable {

    Timer tm = new Timer(1, this);
    private int width, height;
    private ArrayList<LightBike> bikeList = new ArrayList<>();

    public GamePanel(int width, int height){
        super();
        this.requestFocus();
        this.setVisible(true);
        this.width = width;
        this.height = height;

        bikeList.add(new LightBike(100, 50, Color.red, 0));
        bikeList.add(new LightBike(150, 100, Color.blue, 1));

        new Thread(this).start();

    }

    public void run(){

        InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "Face Up One");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "Face Down One");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "Face Right One");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "Face Left One");

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Face Up Two");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Face Down Two");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Face Right Two");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Face Left Two");

        ActionMap ap = this.getActionMap();
        ap.put("Face Up One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(LightBike.DIRECTION_UP);
            }
        });
        ap.put("Face Down One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(LightBike.DIRECTION_DOWN);
            }
        });
        ap.put("Face Right One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(LightBike.DIRECTION_RIGHT);
            }
        });
        ap.put("Face Left One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(LightBike.DIRECTION_LEFT);
            }
        });
        ap.put("Face Up Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(LightBike.DIRECTION_UP);
            }
        });
        ap.put("Face Down Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(LightBike.DIRECTION_DOWN);
            }
        });
        ap.put("Face Right Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(LightBike.DIRECTION_RIGHT);
            }
        });
        ap.put("Face Left Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(LightBike.DIRECTION_LEFT);
            }
        });

        tm.start();
    }

    public void actionPerformed(ActionEvent a){

        for(int i = 0; i < bikeList.size(); i++){
            bikeList.get(i).accelerate();
        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);

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
            g.fillRect(currentBike.getPosX(), currentBike.getPosY(), currentBike.width, currentBike.height);
        }

    }

}
