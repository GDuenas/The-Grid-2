import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class LightBike extends Rectangle {

    private ArrayList<Rectangle> trails = new ArrayList<>();
    private int velocity = 15, xPos, yPos, trailIndex = 0;

    private int playerNumber;
    private Direction currentDirection;
    Color color;

    public LightBike(int spawn_x, int spawn_y, Color color, int playerNumber){
        super(spawn_x, spawn_y, 50, 50);
        xPos = spawn_x;
        yPos = spawn_y;
        this.color = color;
        this.playerNumber = playerNumber;

        this.currentDirection = Direction.RIGHT;
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

    void turn(Direction newDirection){
        if (isTurnable(newDirection)) {
            currentDirection = newDirection;
        }
    }

    private boolean isTurnable(Direction newDirection){
        switch (newDirection){
            case UP:
                return !(currentDirection == Direction.DOWN);
            case DOWN:
                return !(currentDirection == Direction.UP);
            case LEFT:
                return !(currentDirection == Direction.RIGHT);
            case RIGHT:
                return !(currentDirection == Direction.LEFT);
        }
        return false;
    }

    void accelerate(){
        switch (currentDirection){
            case UP:
                yPos -= velocity;
                break;
            case DOWN:
                yPos += velocity;
                break;
            case LEFT:
                xPos -= velocity;
                break;
            case RIGHT:
                xPos += velocity;
                break;
        }
    }





}
