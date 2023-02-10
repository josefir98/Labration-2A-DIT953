package Objects;

import Abstract.Car;
import Abstract.Truck;

import java.util.Stack;

public class Storage<T extends Car, L extends Truck> {
    private Stack<T> storage = new Stack<T>();

    /**
     * Unloads car from truck and places it within a reasonable distance from truck if platStage is open (1)
     * @param truck is any truck
     * @param car is any car
     * @param platStage is the state of the truck door (open or closed)
     * @return
     */
    public T unLoad(L truck, T car, int platStage) {
        if (platStage == 1) {
            car.setX(truck.getX() - 3);
            car.setY(truck.getY() - 3);
            return storage.pop();
        }else {
            throw new RuntimeException("Platform must be down!");
        }
    }

    /**
     * Adds a car onto a truck if the car is within a reasonable distance from the truck
     * Sets coordinates of car to the coordinates of truck
     * Checks if truck door is open
     * @param truck is any truck
     * @param car is any car
     * @param platStage is the state of the truck door (open or closed)
     */
    public void load(L truck, T car, int platStage) {
        if (distance(truck, car) <= 5 && platStage == 1) {
            storage.add(car);
            car.setX(truck.getX());
            car.setY(truck.getY());
        }else {
            throw new RuntimeException("Car must be within 5 units and platform must be down!");
        }
    }

    /**
     * Calculates distance between truck and car
     * @param truck Getting x and y coordinates of truck
     * @param car Getting x and y coordinates of car
     * @return
     */
    public double distance(L truck, T car) {
        double x1 = truck.getX();
        double y1 = truck.getY();
        double x2 = car.getX();
        double y2 = car.getY();
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
