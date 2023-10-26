import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Random random=new Random();
        //Demonstrating polymorphism by saying exhibiting is-a relationship between Circle and Shape
        //Circle is-a Shape
        Shape shape1 = new Circle("Blue",random.nextFloat(10));
        System.out.println("The properties of the"+" "+shape1.getClass().getName()+" "+"are :");
        shape1.calculateArea();
        shape1.calculatePerimeter();
        /* using this print statement to demonstrate the use of static variable colour
         which belongs to the class and not object of the class */
        System.out.println("The colour of the Circle is: "+Shape.getColour());
        System.out.println();

        //Demonstrating polymorphism by saying exhibiting is-a relationship between Rectangle and Shape
        //Rectangle is-a Shape
        Shape shape2=new Rectangle("Yellow",random.nextFloat(10), random.nextFloat(10));
        System.out.println("The properties of the"+" "+shape2.getClass().getName()+" "+"are :");
        shape2.calculateArea();
        shape2.calculatePerimeter();
        System.out.println("The colour of the Rectangle is: "+Shape.getColour());
        System.out.println();

        //Demonstrating polymorphism by saying exhibiting is-a relationship between Square and Shape
        //Square is-a Shape
        Shape shape3=new Square("Green",random.nextFloat(10));
        System.out.println("The properties of the"+" "+shape3.getClass().getName()+" "+"are :");
        shape3.calculateArea();
        shape3.calculatePerimeter();
        System.out.println("The colour of the Square is: "+Shape.getColour());
        System.out.println();

        //Demonstrating polymorphism by saying exhibiting is-a relationship between Square and Shape
        //Triangle is-a Shape
        Shape shape4=new Triangle("Pink",random.nextFloat(10), random.nextFloat(15), random.nextFloat(5));
        System.out.println("The properties of the"+" "+shape4.getClass().getName()+" "+"are : ");
        shape4.calculateArea();
        shape4.calculatePerimeter();
        System.out.println("The colour of the Triangle is: "+Shape.getColour());
        System.out.println();
    }


}
