import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer Pattern - Observer interface
interface Observer {
    void update(String message);
}

// Observer Pattern - Concrete Observer representing a student
class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received a message: " + message);
    }

    public void askQuestion(String question) {
        System.out.println(name + " asks: " + question);
    }
}

// Observer Pattern - Subject interface
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}

// Observer Pattern - Concrete Subject representing the teacher
class Teacher implements Subject {
    private List<Observer> observers;

    public Teacher() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void answerQuestion(String question) {
        System.out.println("Teacher answers: " + question);
        notifyObservers("Teacher answered: " + question);
    }
}

// Command Pattern - Command interface
interface AssignmentCommand {
    void execute();
}

// Command Pattern - Concrete Command representing an assignment
class HomeworkAssignment implements AssignmentCommand {
    private String description;

    public HomeworkAssignment(String description) {
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.println("New homework assignment: " + description);
    }
}

// Factory Pattern - Factory interface
interface AssignmentFactory {
    AssignmentCommand createAssignment(String description);
}

// Factory Pattern - Concrete Factory for creating homework assignments
class HomeworkAssignmentFactory implements AssignmentFactory {
    @Override
    public AssignmentCommand createAssignment(String description) {
        return new HomeworkAssignment(description);
    }
}

public class DesignPatternDemo {
    public static void main(String[] args) {
        // Observer Pattern - Students observing the teacher
        Teacher teacher = new Teacher();

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        teacher.addObserver(student1);
        teacher.addObserver(student2);

        // Command Pattern - Creating and executing homework assignments
        AssignmentFactory assignmentFactory = new HomeworkAssignmentFactory();
        AssignmentCommand assignment1 = assignmentFactory.createAssignment("Complete Chapter 1");
        AssignmentCommand assignment2 = assignmentFactory.createAssignment("Write a short essay");

        assignment1.execute();
        assignment2.execute();

        // Observer Pattern - Students asking questions and receiving answers
        student1.askQuestion("What is the capital of France?");
        teacher.answerQuestion("The capital of France is Paris");

        student2.askQuestion("How does photosynthesis work?");
        teacher.answerQuestion("Photosynthesis is the process by which plants make their own food using sunlight");

        // Displaying messages received by students
        System.out.println("\nMessages received by students:");
        // Assuming students have read the messages in their respective update methods
    }
}
