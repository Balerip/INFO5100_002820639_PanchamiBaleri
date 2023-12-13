// VehicleFactory using the factory pattern
class VehicleFactory {
    // Factory method to create instances of Vehicle
    public Vehicle createVehicle(String type) {
        if ("Car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("Bike".equalsIgnoreCase(type)) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}

