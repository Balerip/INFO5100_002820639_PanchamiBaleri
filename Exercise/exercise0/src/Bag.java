import java.util.UUID;

class Bag {
    UUID bag_id;
    String bag_type;
    Double bag_capacity;
    String bag_colour;
    Double size;
    String brand;
    boolean has_pockets;
    double price;
    String material;

    Bag(String bag_type, Double bag_capacity, String bag_colour, Double size, String brand, boolean has_pockets, double price, String material) {
        this.bag_id= UUID.randomUUID();
        this.bag_type = bag_type;
        this.bag_capacity = bag_capacity;
        this.bag_colour = bag_colour;
        this.size = size;
        this.brand = brand;
        this.has_pockets = has_pockets;
        this.price = price;
        this.material = material;
        System.out.println("Instance of Bag class created with unique id "+bag_id);
    }

    public void purpose()
    {
        if(this.bag_type=="bagpack")
        {
            System.out.println(this.bag_type+" can be used to carry to school or colleges");
        }
        else if(this.bag_type=="tote")
        {
            System.out.println(this.bag_type+" can be used to carry for shopping");
        }
    }
    public void bag_holding_capacity(double pocket_capacity) {
        if (this.has_pockets) {
            System.out.println("The capacity of " + this.bag_type + " is: " + Double.toString(this.bag_capacity + pocket_capacity));
        } else {
            System.out.println("The capacity of " + this.bag_type + " is: " + Double.toString(this.bag_capacity));
        }
    }

    public void bag_sustainability()
    {
        if(this.material=="cotton" | this.material=="paper")
        {
            System.out.println("This bag is sustainable and is eco-friendly");
        }
    }
}
