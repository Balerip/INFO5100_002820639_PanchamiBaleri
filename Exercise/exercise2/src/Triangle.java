class Triangle extends Shape{
    private final float side_a;
    private final float side_b;
    private final float side_c;


    /*creating a triangle constructor with 3 sides as parameter
    and passing colour as parameter to Super class constructor*/
    public Triangle(String colour,float side_a,float side_b,float side_c)
    {
        super(colour);
        this.side_a=side_a;
        this.side_b=side_b;
        this.side_c=side_c;
    }

    //Overriding the overloaded calculateArea method with parameters of the shape class
    @Override
    public double calculateArea(float base,float height)
    {
        double area=0.5*base*height;
        return area;
    }

    @Override
    //implementing the calculateArea method of the shape class and overriding it
    public void calculateArea()
    {
        System.out.println("The area of the triangle is : "+calculateArea(5.0f,7.0f)+" cm^2");
    }
    //implementing the calculatePerimeter and overriding it
    @Override
    public void calculatePerimeter()
    {
        double perimeter=side_a+side_b+side_c;
        System.out.println("The perimeter of the Triangle is : "+perimeter+" cm");
    }


}