// Singleton wrapper for VehicleFactory
class SingletonVehicleFactoryWrapper {
    private static VehicleFactory instance;

    private SingletonVehicleFactoryWrapper() {
        // private constructor to prevent instantiation
    }

    public static synchronized VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();
        }
        return instance;
    }
}