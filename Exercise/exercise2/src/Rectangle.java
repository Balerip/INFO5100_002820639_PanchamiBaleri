class Rectangle extends Shape {
    //created final variables for rectangle
    private final float length;
    private final float breadth;

    /*parametrised constructor for initializing the variables of Rectangle class
    and calling the super class constructor with the colour variable */
    public Rectangle(String colour,float length,float breadth)
    {
        super(colour);
        this.length=length;
        this.breadth=breadth;
    }

    //implementing the calculateArea method and overriding it
    @Override
    public void calculateArea()
    {

        System.out.println("The area of the Rectangle is : "+length*breadth+" cm^2");
    }

    //implementing the calculatePerimeter method  and overriding it
    @Override
    public void calculatePerimeter()
    {

        System.out.println("The perimeter of the Rectangle is : "+2*(length+breadth)+" cm");
    }

}
