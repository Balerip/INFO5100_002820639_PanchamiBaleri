class Circle extends Shape {
    private final float radius;


    //creating the constructor to call super class constructor with the colour variable and initialising the radius variable
    public Circle(String colour,float radius)
    {
        super(colour);
        this.radius=radius;
    }

    //implementing the calculateArea method and overriding it
   @Override
    public  void calculateArea()
    {
        System.out.println("The area of the circle is : "+Shape.getPi()*radius*radius+" cm^2");
    }

    //implementing the calculatePerimeter method  and overriding it
    @Override
    public void calculatePerimeter()
    {

        System.out.println("The perimeter of the circle is : "+2*Shape.getPi()*radius+" cm");
    }


}
