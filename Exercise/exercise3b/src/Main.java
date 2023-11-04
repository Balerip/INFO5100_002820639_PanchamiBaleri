import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        //Demonstrating polymorphism by saying exhibiting is-a relationship between Circle and Shape
        //Circle is-a Shape

        Shape[] shapes = new Shape[4];

        // Create different shapes
        shapes[0] = new Circle("Blue", random.nextFloat() * 10);
        shapes[1] = new Rectangle("Yellow", random.nextFloat() * 10, random.nextFloat() * 10);
        shapes[2] = new Square("Green", random.nextFloat() * 10);
        shapes[3] = new Triangle("Pink", random.nextFloat() * 10, random.nextFloat() * 15, random.nextFloat() * 5);

        // Serialize and deserialize shapes using a for loop
        String[] shapeFiles = {"circle.ser", "rectangle.ser", "square.ser", "triangle.ser"};

        for (int i = 0; i < shapes.length; i++) {
            SerializeDeserialize.serialize(shapes[i], shapeFiles[i]);
            Shape deserializedShape = SerializeDeserialize.deserialize(shapeFiles[i]);
            System.out.println("Deserialized " + shapes[i].getClass().getSimpleName() + ":");
            printData(deserializedShape);
        }


    }

    public static void printData(Shape shape)
    {
        System.out.println("The properties of the"+" "+shape.getClass().getSimpleName()+" "+"are :");
        shape.calculateArea();
        shape.calculatePerimeter();
        /* using this print statement to demonstrate the use of static variable colour
         which belongs to the class and not object of the class */
        System.out.println("The colour of the "+shape.getClass().getSimpleName() +" is: "+shape.getColour());
        System.out.println();
    }


}
