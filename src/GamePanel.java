import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, Runnable {

    Timer tm = new Timer(15, this);
    private int width, height;
    private ArrayList<LightBike> bikeList = new ArrayList<>();
    private ArrayList<Rectangle> listWall = new ArrayList<>(), player1Explode = new ArrayList<>(), player2Explode = new ArrayList<>();
    private Color player1, player2;


    public GamePanel(int width, int height, Color player1, Color player2) {
        super();
        this.requestFocus();
        this.setVisible(true);
        this.width = width;
        this.height = height;
        this.player1 = player1;
        this.player2 = player2;

        bikeList.add(new LightBike(100, 100, player1, 0, Direction.RIGHT));
        bikeList.add(new LightBike(width - 100, height - 100, player2, 1, Direction.LEFT));

        listWall.add(new Rectangle(0, 0, 50, height));
        listWall.add(new Rectangle(0, 0, width/2, 50));
        listWall.add(new Rectangle(0, height - 50, width/2, 50));

        listWall.add(new Rectangle(width - 50, 0, 50, height));
        listWall.add(new Rectangle(width/2, height - 50, width/2, 50));
        listWall.add(new Rectangle(width/2, 0, width/2, 50));

        new Thread(this).start();

    }

    public void run() {

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
                bikeList.get(0).turn(Direction.UP);
            }
        });
        ap.put("Face Down One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(Direction.DOWN);
            }
        });
        ap.put("Face Right One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(Direction.RIGHT);
            }
        });
        ap.put("Face Left One", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(0).turn(Direction.LEFT);
            }
        });
        ap.put("Face Up Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(Direction.UP);
            }
        });
        ap.put("Face Down Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(Direction.DOWN);
            }
        });
        ap.put("Face Right Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(Direction.RIGHT);
            }
        });
        ap.put("Face Left Two", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bikeList.get(1).turn(Direction.LEFT);
            }
        });

        tm.start();
    }

    public void actionPerformed(ActionEvent a) {

        for (int i = 0; i < bikeList.size(); i++) {
            bikeList.get(i).accelerate();
            if (checkCollision(i)){
                for (int j = 0; j < bikeList.size(); j++){
                    bikeList.get(j).setVelocity(0);
                }
            }
        }

        repaint();
    }

    private boolean checkCollision(int bike){

        int opposite;

        if (bike == 0){
            opposite = 1;
        } else{
            opposite = 0;
        }

        Rectangle collider = bikeList.get(bike);
        ArrayList<Rectangle> trails = bikeList.get(bike).trails;
        for (int i = 2; i < trails.size(); i++){
            if (collider.intersects(trails.get(i))){
                return true;
            }
        }



        return false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);

        Color stripe = new Color(0, 165, 161);
        g.setColor(stripe);
        int divider = 20;
        for (int i = 0; i < divider; i++) {
            g.drawLine(width / divider + (width / divider) * i, 0, width / divider + (width / divider) * i, height);
            g.drawLine(0, width / divider + (width / divider) * i, width, width / divider + (width / divider) * i);
        }

        for (int i = 0; i < listWall.size(); i++) {
            if ( i < listWall.size()/2){
                g.setColor(player1);
            } else {
                g.setColor(player2);
            }
            g.fillRect(listWall.get(i).x, listWall.get(i).y, listWall.get(i).width, listWall.get(i).height);
        }


        for (int i = 0; i < bikeList.size(); i++) {
            LightBike currentBike = bikeList.get(i);
            ArrayList<Rectangle> trails = currentBike.trails;
            g.setColor(currentBike.getColor());
            for (int j = 0; j < currentBike.trails.size(); j++) {
                if (j%2 == 0){
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.green);
                }

                g.fillRect(trails.get(j).x, trails.get(j).y, trails.get(j).width, trails.get(j).height);
            }
            g.setColor(Color.white);
            g.fillRect(currentBike.getPosX(), currentBike.getPosY(), currentBike.width, currentBike.height);
        }

    }

}
