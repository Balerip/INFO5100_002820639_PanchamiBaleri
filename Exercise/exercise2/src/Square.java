class Square extends Shape {

    private float side;
    //creating the constructor to call super class constructor with the colour variable and initialising the side variable
    public Square(String colour, float side)
    {
        super(colour);
        this.side=side;
    }
    //implementing the calculateArea and overriding it
    @Override
    public void calculateArea()
    {
        System.out.println("The Area of the Square is : "+Math.pow(side,2)+" cm^2");
    }
    //implementing the calculatePerimeter and overriding it
    @Override
    public void calculatePerimeter()
    {
        System.out.println("The Perimeter of the Square is : "+4*side+" cm");
    }
}
