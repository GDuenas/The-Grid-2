import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class LightBike extends Rectangle {

    public ArrayList<Rectangle> trails = new ArrayList<>();
    private int velocity = 5, xPos, yPos;
    private Direction currentDirection;
    Color color;

    public LightBike(int spawn_x, int spawn_y, Color color, int playerNumber, Direction startingDirection){
        super(spawn_x, spawn_y, 12, 12);
        xPos = spawn_x;
        yPos = spawn_y;
        this.color = color;

        trails.add(new Rectangle(spawn_x, spawn_y, 12, 12));

        this.currentDirection = startingDirection;
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
        if (isTurnable(newDirection) && velocity != 0) {
            currentDirection = newDirection;
            trails.add(0, new Rectangle(xPos, yPos, 12, 12));
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
                trails.get(0).y -= velocity;
                trails.get(0).height += velocity;
                break;
            case DOWN:
                yPos += velocity;
                trails.get(0).height += velocity;
                break;
            case LEFT:
                xPos -= velocity;
                trails.get(0).x -= velocity;
                trails.get(0).width += velocity;
                break;
            case RIGHT:
                xPos += velocity;
                trails.get(0).width += velocity;
                break;
        }
    }





}
