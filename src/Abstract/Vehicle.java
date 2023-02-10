package Abstract;

import java.awt.*;

public abstract class Vehicle implements Movable {

    private String modelName; // The car model name
    private Color color; // Color of the car
    private double currentSpeed; // The current speed of the car
    private double x;
    private double y;
    private Dir curDir;

    public abstract double speedFactor();
    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    /**
     * enum for direction of car
     */
    private enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Constructor for Vehicle
     * @param modelName is the type of car
     * @param color color is the color
     */
    public Vehicle(String modelName, Color color) {
        this.modelName = modelName;
        this.color = color;
        this.curDir = Dir.RIGHT;
    }

    /**
     * Getter for model name of vehicle
     * @return
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Getter for current speed of car
     * @return
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Takes current speed and sees that it does not overstep enginePower
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Getter for color of Vehicle
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for color of car
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Getter for x pos of vehicle
     * @return
     */
    public double getX() {
        return x;
    }
    /**
     * Setter for x pos of vehicle
     * @return
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Getter for y pos of vehicle
     * @return
     */
    public double getY() {
        return y;
    }
    /**
     * Setter for y pos of vehicle
     * @return
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for current direction of car
     * @return
     */
    public Dir getCurDir() {
        return curDir;
    }

    /**
     * Setter for current direction of car
     * @return
     */
    public void setCurDir(Dir curDir) {
        this.curDir = curDir;
    }

    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Breaks the car and checks if amount is outside the parameter 0 to 1
     * @param amount
     */
    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Moving position of the car on the x and y axis
     */
    @Override
    public void move() {
        if (curDir == Dir.RIGHT) {
            x += currentSpeed;
        } else if (curDir == Dir.LEFT) {
            x -= currentSpeed;
        } else if (curDir == Dir.UP) {
            y += currentSpeed;
        } else if (curDir == Dir.DOWN) {
            y -= currentSpeed;
        }
    }

    /**
     * Turning car left depending of current orientation
     */
    @Override
    public void turnLeft() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.UP) {
            curDir = Dir.LEFT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    /**
     * Turning car right depending of current orientation
     */
    @Override
    public void turnRight() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.UP) {
            curDir = Dir.RIGHT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.LEFT;
        }
    }
}
