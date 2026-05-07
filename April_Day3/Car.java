package April_Day3;

public class Car {
	
    private boolean engineStatus;  
    private int speed;
    private double fuelLevel;      

    
    public Car(double fuelLevel) {
        this.engineStatus = false;
        this.speed = 0;
        this.fuelLevel = fuelLevel;
    }

    
    public void startEngine() {
        if (fuelLevel > 0) {
            engineStatus = true;
            System.out.println("Engine started.");
        } else {
            System.out.println("Cannot start engine. Fuel tank empty!");
        }
    }

    
    public void stopEngine() {
        engineStatus = false;
        speed = 0;
        System.out.println("Engine stopped.");
    }

    
    public void accelerate(int increase) {
        if (!engineStatus) {
            System.out.println("Engine is OFF. Start engine first!");
        } else if (fuelLevel <= 0) {
            System.out.println("Out of fuel! Cannot accelerate.");
        } else {
            speed += increase;
            fuelLevel -= increase * 0.1; 
            System.out.println("Accelerated. Current speed: " + speed + " km/h");
        }
    }

    
    public void refuel(double liters) {
        fuelLevel += liters;
        System.out.println("Refueled " + liters + " liters. Current fuel: " + fuelLevel);
    }

   
    public boolean isEngineOn() {
        return engineStatus;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
}

public class CarTest {
    public static void main(String[] args) {
        Car myCar = new Car(5.0); // initial fuel

        myCar.startEngine();
        myCar.accelerate(20);
        myCar.accelerate(30);
        System.out.println("Fuel left: " + myCar.getFuelLevel());

        myCar.stopEngine();
        myCar.refuel(10);
    }
}

}


