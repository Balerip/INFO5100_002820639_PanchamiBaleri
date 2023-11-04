//created an abstract class Shape
public abstract class Shape implements java.io.Serializable
{
    private static final double pi=Math.PI;// created pi as static and final variable
    private String colour;// created the colour variable as static

    //initialised the Shape constructor with colour parameter
    public Shape(String colour)
    {
        this.colour=colour;
    }

    //getter method for colour variable
    public String getColour() {
        return colour;
    }

    //creating abstarct calculateArea method which will be implemented in the child classes
    abstract public void calculateArea();


    /*demonstrating method overloading as a part of polymorphism on calculate area method
    and overriding this method in the triangle class*/
    public double calculateArea(float base,float height)
    {
        return 0.5*base*height;
    }


    //creating abstract calculatePerimeter method which will be implemented in the child classes
    abstract public  void calculatePerimeter();



    //getter method for pi variable
    public static double getPi() {
        return pi;
    }
}

