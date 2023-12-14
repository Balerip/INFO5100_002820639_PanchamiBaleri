public class DesignPatternImplementation {
    public static void main(String[] args)
    {
        // Using the  Singleton, Factory, and Observer design patterns
        VehicleFactory vehicleFactory = SingletonVehicleFactoryWrapper.getInstance();

        // Create a Car
        Vehicle car = vehicleFactory.createVehicle("Car");
        car.start();
        car.stop();

        System.out.println();

        // Create a Bicycle
        Vehicle bike = vehicleFactory.createVehicle("Bike");
        bike.start();
        bike.stop();
        System.out.println();

        // Add observers to vehicles
        Observer carObserver = (Car) car;
        Observer bikeObserver = (Bike) bike;

        //  Letting the observers know about the change of vehicle state
        ((Car) car).addObserver(carObserver);
        car.start(); // This will notify the observer
        System.out.println();

        ((Bike) bike).addObserver(bikeObserver);
        bike.start(); // This will notify the observer
    }
}

