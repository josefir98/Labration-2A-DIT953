package Abstract;

import java.awt.*;

public abstract class Motorized extends Vehicle {
    private double enginePower; // Engine power of the car
    private boolean engineState; // Engine power of the car

    /**
     * Superclass Motorized
     * @param modelName Name of motorized thing
     * @param color Color of motorized thing
     * @param enginePower Engine power of motorized thing
     */
    public Motorized(String modelName, Color color, double enginePower) {
        super(modelName, color);
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Getter for engine power
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Turns engine on
     */
    public void startEngine() {
        engineState = true;
    }

    /**
     * Turns engine off and sets speed to 0
     */
    public void stopEngine() {
        engineState = false;
        setCurrentSpeed(0);
    }

    /**
     * If engine is on, increases currentSpeed variable
     * @param amount
     */
    public void incrementSpeed(double amount) {
        if (engineState) {
            double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
            if (speed > getCurrentSpeed()) {
                setCurrentSpeed(speed);
            }
        }
    }

    /**
     * Decreasing currentSpeed variable
     * @param amount
     */
    public void decrementSpeed(double amount) {
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }
}
