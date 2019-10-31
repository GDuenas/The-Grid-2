import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class LightBike extends Rectangle {

    private ArrayList<Rectangle> trails = new ArrayList<>();
    private int velocity = 1, xPos, yPos;

    public static final int DIRECTION_UP = 0, DIRECTION_DOWN = 1, DIRECTION_LEFT = 2, DIRECTION_RIGHT = 3;
    Color color;

    public LightBike(int spawn_x, int spawn_y, Color color){
        super(spawn_x, spawn_y, 50, 50);
        xPos = spawn_x;
        yPos = spawn_y;
        this.color = color;
    }

    Color getColor(){
        return color;
    }

    int getVelocity(){
        return velocity;
    }

    void setVelocity(int newVel){
        velocity = newVel;
    }

    int getPosX(){
        return xPos;
    }

    void setX(int newX){
        xPos = newX;
    }

    int getPosY(){
        return yPos;
    }

    void setY(int newY){
        yPos = newY;
    }





}
