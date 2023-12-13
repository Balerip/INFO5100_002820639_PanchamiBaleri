import java.util.ArrayList;
import java.util.List;

//Car class implementing Vehicle
public class Car implements Vehicle {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("Car is starting.");
        notifyObservers();
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
        notifyObservers();
    }

    @Override
    public void update() {
        System.out.println("Car state has changed.");
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
