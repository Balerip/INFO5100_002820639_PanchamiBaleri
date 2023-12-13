import java.util.ArrayList;
import java.util.List;

// Bicycle class implementing Vehicle
class Bike implements Vehicle {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("Bike is starting.");
        notifyObservers();
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
        notifyObservers();
    }

    @Override
    public void update() {
        System.out.println("Bike state has changed.");
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Additional methods for attaching and detaching observers
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
