import java.util.UUID;

class Bottle {
    UUID bottle_id;
    String colour;
    String type;
    double size;
    String material;

    boolean has_straw;

    String brand;

    double capacity;

    boolean is_reusable;

    Bottle(String colour, String type, double size, String material, boolean has_straw, String brand, double capacity, boolean is_reusable) {
        this.bottle_id= UUID.randomUUID();
        this.colour = colour;
        this.type = type;
        this.size = size;
        this.material = material;
        this.has_straw = has_straw;
        this.brand = brand;
        this.capacity = capacity;
        this.is_reusable = is_reusable;
        System.out.println("Instance of Bottle class created with unique id"+bottle_id);
    }

    public void bottle_hold_capacity(double amount_to_be_filled) {
        if (amount_to_be_filled > this.capacity) {
            System.out.print("The bottle can be filled only upto the capacity and hence reduce the amount to" + this.capacity);
        }
    }

    public void drink_type() {
        if (this.has_straw) {
            System.out.println("The bottle can be used for drinking coffee");
        }
    }

    public void effect_on_carbon_footprint() {
        if (this.is_reusable) {
            System.out.println("Reduces carbon footprint and can be used to encouraged people to buy such bottles");
        } else {
            System.out.println("Increases carbon footprint and people should be made aware to stop using such bottles");
        }

    }

}
